package com.leo.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	// // Redirección 1
	// @GetMapping("/")
	// public String redirect() {
	// return "redirect:/example3/showform";
	// }

	// Redireccionar con RedirectView
	@GetMapping("/")
	public RedirectView Redirect() {
		return new RedirectView("/example3/showform");
	}

	// Muestra un formulario al escribir localhost:8080/example3/showform
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	// regresa la página con el objeto persona
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		// con @Valid indicamos que debe validar antes
		// BindingResult -- lo usa spring para verificar los campos y guarda los
		// errores en este parámetro
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			// hay errores
			modelAndView.setViewName(FORM_VIEW);
		} else {
			// no hay errores
			modelAndView.setViewName(RESULT_VIEW);
			modelAndView.addObject("person", person);
		}
		return modelAndView;
	}
}
