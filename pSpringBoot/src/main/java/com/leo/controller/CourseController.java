package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leo.entity.Course;
import com.leo.service.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private static final String COURSES_VIEW = "courses";
	private static final Log log = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listCourses")
	public ModelAndView listAllCourse() {
		log.info("Listando todos los cursos ->");
		ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
		modelAndView.addObject("courses", courseService.listAllCourse());
		modelAndView.addObject("course", new Course());
		return modelAndView;
	}

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		log.info("agregando curso ->");
		log.info("Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listCourses";
	}
}
