package com.codeclan.example.CourseBooking_lab.controllers;

import com.codeclan.example.CourseBooking_lab.models.Booking;
import com.codeclan.example.CourseBooking_lab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable Long id){
        java.util.Optional<Booking> payload=bookingRepository.findById(id);
        if(payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "bookings/date")
    public ResponseEntity<List<Booking>> filterBookingsByDate(@RequestParam(name = "date") String date){
        return new ResponseEntity<>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
    }
}
