package com.cydeo.client;

import com.cydeo.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/enrich")
    public ResponseEntity<AddressDTO> enrichAddress(@RequestBody AddressDTO address) {
        AddressDTO enrichedAddress = addressService.enrichAddress(address);
        return ResponseEntity.ok(enrichedAddress);
    }
}
