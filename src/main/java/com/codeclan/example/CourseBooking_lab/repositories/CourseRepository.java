package com.codeclan.example.CourseBooking_lab.repositories;

import com.codeclan.example.CourseBooking_lab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseBystarRating(Integer rating);
}
