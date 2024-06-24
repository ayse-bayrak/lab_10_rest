package com.cydeo.client;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    private final WeatherClient weatherClient;

    public AddressController(AddressService addressService, WeatherClient weatherClient) {
        this.addressService = addressService;
        this.weatherClient = weatherClient;
    }

    @GetMapping("{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByNo(@PathVariable("addressNo") String addressNo) {

        AddressDTO addressDTO = addressService.findByAddressNo(addressNo);
        WeatherResponse weather = weatherClient.getWeather(addressDTO.getCity(), "8325170359dd3ecd6aae8efd3e39a482");
        addressDTO.setCurrentTemperature(weather.getTemperature());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("Success", addressDTO, 200));


    }
}
