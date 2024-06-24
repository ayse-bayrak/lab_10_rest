package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController1 {

    private final AddressService addressService;

    public AddressController1(AddressService addressService) {
        this.addressService = addressService;
    }

    /*
 Endpoint: /api/v1/address/{addressNo}
 HTTP Status Code: 200

 JSON Response Body:
 "success": true
 "message": "Address <addressNo> is successfully retrieved."
 "code":200
 "data":<address data>
*/
    //localhost:8080/api/v1/address/01
    @GetMapping("{addressNo}")
    public ResponseEntity<ResponseWrapper> getAdressByNo(@PathVariable ("addressNo") String addressNo) {
        // I need to find address info based on addressNo--> AddressDTO
        AddressDTO foundAddress = addressService.findByAddressNo(addressNo);
        // Build our custom JSON response which includes Address information -->ResponseWrapper
        ResponseWrapper responseWrapper = ResponseWrapper.builder()
                .success(true)
                .message("Address " + addressNo+ "is successfully retrieved.")
                .code(HttpStatus.OK.value())
                .data(foundAddress).build();
        //return JSON response body along with 200 status code --> ResponseEntity status code 200 and JSON body
       return ResponseEntity.ok(responseWrapper);
        }
    //writing everything in one statement
//        return ResponseEntity.ok(ResponseWrapper.builder()
//                .success(true)
//                .message("Address " + addressNo + " is successfully retrieved.")
//                .code(HttpStatus.OK.value())
//                .data(addressService.findByAddressNo(addressNo)).build());

    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */

    @PutMapping ("{addressNo}")
    public AddressDTO updateAdddressByAddressNo(@PathVariable ("addressNo") String addressNo, @RequestBody AddressDTO address) {
        return addressService.update(addressNo, address);
        } // since requirements only updated data I use very basic endpoint by using @RestController class and return own base dataType (AddressDTO in here)



//    @PutMapping ("{addressNo}")
//    public ResponseEntity<ResponseWrapper> updateAdddressByAddressNo(@PathVariable ("addressNo") String addressNo, @RequestBody AddressDTO address) {
//
//        addressService.update(addressNo, address);
//        return ResponseEntity
//                .ok(new ResponseWrapper("updated data ", addressService.findByAddressNo(addressNo)));
//    }
    /// we use @RequestBody to capture that object, after we captured the object, it is gonna go to database and
    //    // it's gonna replace this object with whatever in the database



}
