package com.example.hpack;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by rouaixs on 12/08/2016.
 */
public class RootElement {

    // call of Deserializer to decode HPACK
    @JsonDeserialize(using = ElementDeserializer.class)
    private Element element;

}
