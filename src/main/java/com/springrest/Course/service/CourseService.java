package com.springrest.Course.service;

import java.util.List;

import com.springrest.Course.model.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public Course getCourse(long id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long id);
}
