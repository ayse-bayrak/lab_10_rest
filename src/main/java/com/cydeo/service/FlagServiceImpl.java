package com.cydeo.service;

import com.cydeo.client.CountryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlagServiceImpl implements FlagService{

    private final CountryClient flagClient;
    private static final String ACCESS_KEY = "9f7ff6d180e8ea81483c03dc0209215b";

    public FlagServiceImpl(CountryClient flagClient) {
        this.flagClient = flagClient;
    }

    @Override
    public String getFlag(String country) {
        List<Map<String, Object>> response = flagClient.getFlag(country);
        if(!response.isEmpty()) {
            Map<String, Object> countryInfo = response.get(0);
            Map<String, Object> flags = (Map<String, Object>)countryInfo.get("flags");
            return (String) flags.get("png");
        }
       throw new RuntimeException("Flag not found for country: " + country);
    }
}
