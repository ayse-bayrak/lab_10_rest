package com.cydeo.client;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import com.cydeo.service.TemperatureService;
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
    private final TemperatureService temperatureService;

    public AddressController(AddressService addressService, WeatherClient weatherClient, TemperatureService temperatureService) {
        this.addressService = addressService;
        this.weatherClient = weatherClient;
        this.temperatureService = temperatureService;
    }

    @GetMapping("{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByNo(@PathVariable("addressNo") String addressNo) {

        AddressDTO addressDTO = addressService.findByAddressNo(addressNo);
        addressDTO.setCurrentTemperature(temperatureService.getTemperature(addressDTO.getCountry()));
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("Address " + addressNo + " is successfully retrieved.", addressDTO, 200));


    }
}
