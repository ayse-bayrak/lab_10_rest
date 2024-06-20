package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.ParentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parent")
    public ResponseEntity<ResponseWrapper> getParents() {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .header("Parents", "Returned")
                .body(new ResponseWrapper("Parents are successfully retrieved. ", parentService.findAll()));
    }

     /*
           Endpoint: /api/v1/parent
           HTTP Status Code: 200
           Custom Response Header: "Parents", "Returned"

           JSON Response Body:
           "success": true
           "message": "Parents are successfully retrieved."
           "code":200
           "data":<parents data>
     */
}
