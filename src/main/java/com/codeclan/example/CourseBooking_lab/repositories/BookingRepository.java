package com.codeclan.example.CourseBooking_lab.repositories;

import com.codeclan.example.CourseBooking_lab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
