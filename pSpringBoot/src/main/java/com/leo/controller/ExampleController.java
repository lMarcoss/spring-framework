package com.leo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leo.component.ExampleComponent;
import com.leo.model.Person;
import com.leo.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	/*
	 * Formas de retornar una plantilla
	 */

	// FORMA 1

	// @RequestMapping(value = "/exampleString", method = RequestMethod.GET) --
	// sustituido por la linea que sigue
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", new Person("Leo", 23));
		return EXAMPLE_VIEW;
	}

	// FORMA 2

	// @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET )
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Marcos", 23));
		return mav;
	}

	@GetMapping("/examplePeople")
	public String examplePeople(Model model) {
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

}
