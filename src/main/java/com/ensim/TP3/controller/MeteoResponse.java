package com.ensim.TP3.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MeteoResponse {
    private Meteo [] forecast;

    public MeteoResponse() {
    }

    public Meteo[] getForecast() {
        return forecast;
    }

}
