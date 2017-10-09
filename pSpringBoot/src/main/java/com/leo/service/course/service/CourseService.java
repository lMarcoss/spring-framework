package com.leo.service.course.service;

import java.util.List;

import com.leo.entity.Course;

public interface CourseService {
	public List<Course> listAllCourse();

	public Course addCourse(Course course);

	public int removeCourse(int id);

	public Course updateCourse(Course course);
}
