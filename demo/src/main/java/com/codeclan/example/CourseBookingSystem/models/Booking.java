package com.codeclan.example.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "course_id" , nullable = false)
    private Course course;

    @ManyToOne
    @JsonIgnoreProperties({"bookings"})
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;

    @Column(name = "date")
    private String date;

    public Booking(Course course, Customer customer, String date) {
        this.course = course;
        this.customer = customer;
        this.date = date;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
