package com.leo.service.course.service;

import java.util.List;

import com.leo.entity.Course;

public interface CourseService {
	// CRUD
	public Course addCourse(Course course);

	public List<Course> listAllCourse();

	public Course updateCourse(Course course);

	public int removeCourse(int id);
	
	public Course findCourse(int id);
}
