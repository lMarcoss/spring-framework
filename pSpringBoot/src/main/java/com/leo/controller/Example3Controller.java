package com.leo.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.leo.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

//	// Redirección 1
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}

	// Redireccionar con RedirectView
	@GetMapping("/")
	public RedirectView Redirect() {
		return new RedirectView("/example3/showform");
	}

	// Muestra un formulario al escribir localhost:8080/example3/showform
	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	// regresa la página con el objeto persona
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
}
