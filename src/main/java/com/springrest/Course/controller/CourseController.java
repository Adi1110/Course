package com.springrest.Course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Course.model.Course;
import com.springrest.Course.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.service.getAllCourses();
	}
	
	
	//get the course by id
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable long id) {
		return this.service.getCourse(id);
				
	}
	
	
	// create the course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.service.addCourse(course);
	}
	
	
	// update the course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.service.updateCourse(course);
	}
	
	
	//delete the course
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long id){
		
		try {
				this.service.deleteCourse(id);
				return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
