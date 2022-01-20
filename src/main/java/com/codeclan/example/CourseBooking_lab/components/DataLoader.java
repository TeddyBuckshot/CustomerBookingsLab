package com.codeclan.example.CourseBooking_lab.components;

import com.codeclan.example.CourseBooking_lab.models.Booking;
import com.codeclan.example.CourseBooking_lab.models.Course;
import com.codeclan.example.CourseBooking_lab.models.Customer;
import com.codeclan.example.CourseBooking_lab.repositories.BookingRepository;
import com.codeclan.example.CourseBooking_lab.repositories.CourseRepository;
import com.codeclan.example.CourseBooking_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args) {
        Course java=new Course("Java","Edinburgh", 5);
        courseRepository.save(java);

        Course python=new Course("Python","Glasgow", 4);
        courseRepository.save(python);

        Course react=new Course("React","London", 3);
        courseRepository.save(react);

        Course art =new Course("Art","Edinburgh", 5);
        courseRepository.save(art);


        Course music=new Course("Music","London", 2);
        courseRepository.save(music);


        Customer customer1 = new Customer("Sam", "Aberdeen", 32);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Ina", "Edinburgh", 21);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("James", "Glasgow", 16);
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Chloe", "London", 40);
        customerRepository.save(customer4);

        Booking booking1 = new Booking("01.02.2022", customer1, java);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("05.02.2022", customer2, python);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("13.02.2022", customer3, music);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("4.03.2022", customer4, react);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("01.02.2022", customer1, art);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("04.03.2022", customer2, react);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("13.02.2022", customer3, music);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("05.02.2022", customer4, python);
        bookingRepository.save(booking8);

        Booking booking9 = new Booking("01.02.2022", customer3, java);
        bookingRepository.save(booking9);

        Booking booking10 = new Booking("05.02.2022", customer2, python);
        bookingRepository.save(booking10);
    }
    }
