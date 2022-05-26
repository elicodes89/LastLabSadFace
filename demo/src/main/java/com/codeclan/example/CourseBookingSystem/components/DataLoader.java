package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Eli" , "Valencia" , 19);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Amanda" , "Caracas" , 20);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Elina" , "Barcelona" , 21);
        customerRepository.save(customer3);

        Course course1 = new Course("Math" , "Edinburgh" , 2);
        courseRepository.save(course1);

        Course course2 = new Course("React" , "Paris" , 5);
        courseRepository.save(course2);

        Course course3 = new Course("Python" , "Dalkeith" , 4);
        courseRepository.save(course3);

        Booking booking1 = new Booking(course1 , customer2 , "12/11/2022");
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(course3 , customer1 , "12/10/2022");
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(course2 , customer3 , "12/12/2022");
        bookingRepository.save(booking3);

    }
}
