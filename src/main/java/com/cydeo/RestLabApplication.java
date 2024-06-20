package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
//@ImportAutoConfiguration({FeignAutoConfiguration.class}) // I got error like Parameter 0 of constructor in com.cydeo.controller.Consume FeignClient required a bean of type 'org.springframework.cloud.openfeign.FeignContext' that could not be found. and I added this one and it is fixed but later I fixed spring-cloud-starter-openfeign dependency as version 4.1.2
public class RestLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestLabApplication.class, args);
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
