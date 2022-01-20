package com.codeclan.example.CourseBooking_lab.repositories;

import com.codeclan.example.CourseBooking_lab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseId(Long id);

    List<Customer> findCustomerByTownAndBookingsCourseName(String town, String name);

    List<Customer> findCustomerByAgeAndTownAndBookingsCourseName(Integer age, String town, String name);



}
