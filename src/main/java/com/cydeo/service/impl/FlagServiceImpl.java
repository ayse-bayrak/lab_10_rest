package com.cydeo.service.impl;

import com.cydeo.client.FlagClient;
import com.cydeo.service.FlagService;

import java.util.List;
import java.util.Map;

public class FlagServiceImpl implements FlagService {
    private final FlagClient flagClient;

    public FlagServiceImpl(FlagClient flagClient) {
        this.flagClient = flagClient;
    }

    @Override
    public String getFlag(String city) {
        List<Map<String, Object>> response = flagClient.getFlag(city);
        if (!response.isEmpty()) {
            Map<String, Object> flags = (Map<String, Object>) response.get(0).get("flags");
            return (String) flags.get("png");
        }
        throw new RuntimeException("Flag not found for country"+ city);
    }
}
