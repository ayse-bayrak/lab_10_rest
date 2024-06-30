package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)  // only get nonnull values, these are Jackson annotation (class level)
@JsonIgnoreProperties(ignoreUnknown = true) // do not related get method, related to post or put request, if you have anny fields
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String addressNo;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String flag;

    private AddressType addressType;

    private Integer currentTemperature;

    // for deserialisation

//    public AddressDTO(String addressNo) {
//        this.addressNo = addressNo;
//    }
}
