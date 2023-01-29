package com.ensim.TP3.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressQuery {
    @JsonProperty
    private AddressFeature [] features;

    public AddressQuery() {
    }

    public AddressFeature [] getFeatures() {
        return features;
    }

    public void setFeatures(AddressFeature []features) {
        this.features = features;
    }
}
