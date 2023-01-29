package com.ensim.TP3.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiRequest {
    @JsonProperty
    private AddressFeature [] features;


    public AddressFeature [] getFeatures() {
        return features;
    }

}
