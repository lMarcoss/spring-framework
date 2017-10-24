package com.leo.service.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leo.entity.Course;
import com.leo.repository.CourseJpaRepository;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public Course addCourse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public List<Course> listAllCourse() {
		return courseJpaRepository.findAll();
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course findCourse(int id) {
		return courseJpaRepository.findById(id);
	}
}
