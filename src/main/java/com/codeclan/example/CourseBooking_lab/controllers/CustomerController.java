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

//    @GetMapping(value = "/customers/course")
//    public ResponseEntity<List<Customer>> filterCustomerByCourseName(@RequestParam(name = "course") String course){
//        return new ResponseEntity<>(customerRepository.findCustomerByCourse(course), HttpStatus.OK);
//    }
}
