package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getStudents(){

        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(new ResponseWrapper("Students are successfully retrieved.", studentService.findAll() ));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createStudent(@RequestBody StudentDTO studentDTO){

        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(new ResponseWrapper("Student is successfully created.", studentService.createStudent(studentDTO) ));
    }

     /*
           Endpoint: /api/v1/student
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Students are successfully retrieved."
           "code":200
           "data":<students data>
     */

    /*
          Endpoint: /api/v1/student
          HTTP Status Code: 201

          JSON Response Body:
          "success": true
          "message": "Student is successfully created."
          "code":201
          "data":<created student data>
    */

}
