package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

//define Feign Client to access RestCountries API
@FeignClient(name = "FlagClient", url = "https://restcountries.com/v3.1/name")
public interface CountryClient {

    @GetMapping("/{name}")
    List<Map<String, Object>> getFlag(@PathVariable("name") String country);

}
