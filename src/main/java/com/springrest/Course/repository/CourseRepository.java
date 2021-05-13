package com.springrest.Course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.Course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
