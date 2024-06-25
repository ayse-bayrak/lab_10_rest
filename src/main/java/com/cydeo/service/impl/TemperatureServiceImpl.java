package com.cydeo.service.impl;

import com.cydeo.client.WeatherClient;
import com.cydeo.service.TemperatureService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private final WeatherClient weatherClient;
    private static final String ACCESS_KEY = "9f7ff6d180e8ea81483c03dc0209215b";

    public TemperatureServiceImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public Integer getTemperature(String city) {

        Map<String, Object> response =  weatherClient.getWeather(city, ACCESS_KEY);
        Map<String, Object> current = (Map<String, Object>) response.get("current");
        return (Integer) current.get("temperature");
    }
}
