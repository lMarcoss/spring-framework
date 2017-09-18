package com.leo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leo.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exComponent;

	/*
	 * Formas de retornar una plantilla
	 */

	// FORMA 1

	// @RequestMapping(value = "/exampleString", method = RequestMethod.GET) --
	// sustituido por la linea que sigue
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exComponent.sayHello();
		model.addAttribute("person", new Person("Leo", 23));
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
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}

	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			people.add(new Person("person_" + i, i + 20));
		}
		return people;
	}
}
