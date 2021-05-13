package com.springrest.Course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.Course.model.Course;
import com.springrest.Course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	
	/*
	 * List<Course> list;
	 * 
	 * public CourseServiceImpl() {
	 * 
	 * list = new ArrayList<>(); list.add(new Course(125L, "Java Core",
	 * "this course contains java core.")); list.add(new Course(127L,
	 * "Python Basic", "this course contains basic python.")); }
	 */
	
	@Autowired
	private CourseRepository repo;
	
	@Override
	public List<Course> getAllCourses() {
		//return list;
		return repo.findAll();
	}

	@Override
	public Course getCourse(Long id) {
		
		/*
		 * Course course = null; for(Course c:list) {
		 * 
		 * if(c.getId()==id) { course=c; break; } }
		 */
		
		return repo.findById(id).get();
	}

	
	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		repo.save(course);
		return course;
	}

	
	@Override
	public Course updateCourse(Course course) {
		
		/*list.forEach(e ->{
			if(e.getId()==course.getId()) {
			   e.setTitle(course.getTitle());
			   e.setDesc(course.getDesc());
			}   
		});*/
		
		repo.save(course);
		return course;
	}

	
	@Override
	public void deleteCourse(Long id) {
		//list=this.list.stream().filter(e -> e.getId()!=id).collect(Collectors.toList());
		repo.deleteById(id);
	}

}
