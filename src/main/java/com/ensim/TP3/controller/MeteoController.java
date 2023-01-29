
package com.ensim.TP3.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

@Controller
public class MeteoController {

    @PostMapping("/meteo")
    public String meteo(@RequestBody String adress, Model model) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        String token = "2f76c199aade9448050809c29e7e0b917f139d0283e357062af409ce2979aa22";
        LocalDate date = LocalDate.now();

        String adresseUri = "https://api-adresse.data.gouv.fr/search/?q=" + adress;
        ApiRequest addr = restTemplate.getForObject(adresseUri, ApiRequest.class);

        assert addr != null;
        String city = addr.getFeatures()[0].getProperties().getCity();
        double [] coor = addr.getFeatures()[0].getGeometry().getCoordinates();
        String meteoUri = "https://api.meteo-concept.com/api/forecast/daily?token=" + token + "&latlng=" + coor[1] + "," + coor[0];
        MeteoResponse meteo = restTemplate.getForObject(meteoUri, MeteoResponse.class);
        int tmin, tmax, probarain;
        assert meteo != null;
        tmin = meteo.getForecast()[0].getTmin();
        tmax = meteo.getForecast()[0].getTmax();
        probarain = meteo.getForecast()[0].getProbarain();

        model.addAttribute("city", city);
        model.addAttribute("tmin", tmin);
        model.addAttribute("tmax", tmax);
        model.addAttribute("probarain", probarain);
        model.addAttribute("date", date);

        return "meteo";
    }

}
