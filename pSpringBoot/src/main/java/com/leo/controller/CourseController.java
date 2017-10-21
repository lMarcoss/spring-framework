package com.leo.controller;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leo.entity.Course;
import com.leo.service.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private static final String COURSES_VIEW = "courses";

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listCourses")
	public ModelAndView listAllCourse() {
		ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
		modelAndView.addObject("courses", courseService.listAllCourse());
		return modelAndView;
	}

	@GetMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		courseService.addCourse(course);
		return "redirect:/listCourses";
	}
}
