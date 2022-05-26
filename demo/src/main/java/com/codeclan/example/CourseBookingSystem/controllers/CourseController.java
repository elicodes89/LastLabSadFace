package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findCourses(@RequestParam(name = "rating" , required = false)
                                                                Integer rating ,
                                                    @RequestParam(name = "customer" , required = false)
                                                    String customer) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating.intValue()), HttpStatus.OK);
        } else if(customer != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customer) , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }
    }

}
