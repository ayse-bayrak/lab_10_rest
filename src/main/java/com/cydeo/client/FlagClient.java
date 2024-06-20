package com.cydeo.client;

import com.cydeo.entity.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@FeignClient (url="https://restcountries.com/v3.1/name/{name}", name="FLAG-CLIENT")
public interface FlagClient {
    @GetMapping()
    Country getCountry();

}
