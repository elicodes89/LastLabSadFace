package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControler {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findCustomers(@RequestParam(name = "course", required = false) String course,
                                                        @RequestParam(name = "town" , required = false) String town) {
        if(town != null && course != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseNameIgnoreCase(town , course) ,
                    HttpStatus.OK);
        }
        else if (course != null) {

            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }
}