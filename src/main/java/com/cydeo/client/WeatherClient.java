package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//define Feign Client to access WeatherStack API
@FeignClient(name = "weatherClient", url = "http://api.weatherstack.com")
public interface WeatherClient {

    @GetMapping("/current") // wetaherstack API require /current
    Map<String, Object> getWeather(@RequestParam("query") String city, @RequestParam("access_key") String accessKey);
}
