package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.leo.entity.Course;
import com.leo.service.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private static final String COURSES_VIEW = "courses";
	private static final String EDIT_VIEW = "editcourse";
	private static final Log log = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		log.info("Add new course->\nParam: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listCourses";
	}

	@GetMapping("/listCourses")
	public ModelAndView listAllCourse() {
		ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
		log.info("List all courses ->");
		modelAndView.addObject("courses", courseService.listAllCourse());
		modelAndView.addObject("course", new Course());
		return modelAndView;
	}

	@PostMapping("/updateCourse")
	public String updateCourse(@ModelAttribute("course") Course course) {
		log.info("update course ->\nParam: " + course);
		courseService.updateCourse(course);
		return "redirect:/courses/listCourses";
	}

	@GetMapping("/removeCourse/{id}")
	public String removeCourse(@PathVariable("id") int id) {
		log.info("remove course -->\nParam: " + id);
		courseService.removeCourse(id);
		return "redirect:/courses/listCourses";
	}

	// localhost:8080/courses/editCourse?id=1
	@GetMapping("/editCourse")
	public ModelAndView editCourse(@RequestParam(name = "id") int id) {
		log.info("Show course for edit");
		ModelAndView modelAndView = new ModelAndView(EDIT_VIEW);
		modelAndView.addObject("course", courseService.findCourse(id));
		return modelAndView;
	}
}
