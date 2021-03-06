package com.codeclan.example.CourseBooking_lab.controllers;

import com.codeclan.example.CourseBooking_lab.models.Customer;
import com.codeclan.example.CourseBooking_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> filterByCustom(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/courses")
    public ResponseEntity<List<Customer>> filterCustomerByCourseName(
            @RequestParam(name = "course_id", required = false) Long id) {
        if (id!=null){
        return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseId(id), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "customers/courseLocation")
//    public ResponseEntity<List<Customer>> filterCustomerByCourseAndTown(@RequestParam(name = "name") String name, @RequestParam(name = "town") String town){
//        return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseNameAndBookingsCourseTown(name, town), HttpStatus.OK);
//    }
    @GetMapping(value = "customers/courseLocation")
    public ResponseEntity<List<Customer>> filterCustomerByTownAndCourse(@RequestParam(name = "town") String town, @RequestParam(name = "course") String course){
        return new ResponseEntity<>(customerRepository.findCustomerByTownAndBookingsCourseName(town, course), HttpStatus.OK);
    }

    @GetMapping(value = "customers/age/town/course")
    public ResponseEntity<List<Customer>> filterCustomerByAgeTownAndCourse(@RequestParam(name = "age") Integer age, @RequestParam(name = "town") String town, @RequestParam(name = "course") String course){
        return new ResponseEntity<>(customerRepository.findCustomerByAgeAndTownAndBookingsCourseName(age, town, course), HttpStatus.OK);
    }
}
