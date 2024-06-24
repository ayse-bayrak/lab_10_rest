package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "http://api.weatherapi.com")
public interface WeatherClient {

    @GetMapping("/v1/current.json")
    WeatherResponse getWeather(@RequestParam("q") String city, @RequestParam("key") String apiKey);
}
