package com.example.hpack;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Created by rouaixs on 12/08/2016.
 * HPACK decoding of JSON element https://github.com/WebReflection/json.hpack/wiki
 */
public class ElementDeserializer extends JsonDeserializer<Element> {
    public Element deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        int size = node.size() - 1;
        Element elevations = new Element();
        elevations.setAttr1(new double[size]);
        elevations.setAttr2(new double[size]);

        for (int i = 1; i < node.size(); i++) {
            JsonNode jsonNode = node.get(i);
            elevations.getAttr1()[i - 1] = jsonNode.get(0).doubleValue();
            elevations.getAttr2()[i - 1] = jsonNode.get(1).doubleValue();
        }
        return elevations;
    }
}
