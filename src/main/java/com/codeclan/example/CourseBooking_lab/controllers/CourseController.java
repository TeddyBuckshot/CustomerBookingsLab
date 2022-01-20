package com.codeclan.example.CourseBooking_lab.controllers;

import com.codeclan.example.CourseBooking_lab.models.Booking;
import com.codeclan.example.CourseBooking_lab.models.Course;
import com.codeclan.example.CourseBooking_lab.models.Customer;
import com.codeclan.example.CourseBooking_lab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.IntegerSyntax;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id){
        Optional<Course> payload=courseRepository.findById(id);
        if(payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> filterCourseByRating(@RequestParam(name = "rating") Integer rating){
        return new ResponseEntity<>(courseRepository.findCourseBystarRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "courses/customers")
    public ResponseEntity<List<Course>> filterCourseByCustomer(@RequestParam(name = "customer_id") Long id){
        return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerId(id), HttpStatus.OK);
    }
}
