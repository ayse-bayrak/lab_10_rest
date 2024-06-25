package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//define Feign Client to access RestCountries API
@FeignClient(name = "FlagClient", url = "https://restcountries.com/v3.1/name")
public interface FlagClient {

    @GetMapping("/{country}")
    List<Map<String, Object>> getFlag(@PathVariable("country") String country);

}
