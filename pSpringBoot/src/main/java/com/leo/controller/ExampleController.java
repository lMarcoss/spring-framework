package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	/*
	 * Formas de retornar una plantilla
	 */

	// FORMA 1

	// @RequestMapping(value = "/exampleString", method = RequestMethod.GET) --
	// sustituido por la linea que sigue
	@GetMapping("/exampleString")
	public String exampleString() {
		return EXAMPLE_VIEW;
	}

	// FORMA 2

	// @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET )
	@GetMapping("/exampleMAV ")
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);
	}
}
