package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	private static final String EXAMPLE2_VIEW = "example2";

	// localhost:8080/example2/request1?nm=JON
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "null") String name) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
		modelAndView.addObject("nm", name);
		return modelAndView;
	}

	// localhost:8080/example2/reques2/leo
	@GetMapping("/request2/{name}")
	public ModelAndView request2(@PathVariable("name") String name) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
