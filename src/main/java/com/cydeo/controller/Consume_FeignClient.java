package com.cydeo.controller;

import com.cydeo.client.FlagClient;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.entity.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Consume_FeignClient {
    private final FlagClient flagClient;

    public Consume_FeignClient(FlagClient flagClient) {
        this.flagClient = flagClient;
    }

    @GetMapping()
    public Country getFlag() {
        return flagClient.getCountry();
    }
}
