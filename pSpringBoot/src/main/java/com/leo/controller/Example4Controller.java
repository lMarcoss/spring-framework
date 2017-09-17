package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	private static final String P404 = "404";
	private static final String P500 = "500";

	// Devuelve una página 404.html
	@GetMapping("/404")
	public String p404() {
		return P404;
	}

	@GetMapping("/500")
	public String p500() {
		return P500;
	}

	// Metodo para provocar el error 500
	@GetMapping("/error")
	public String error() {
		int i = 6 / 0;
		return "prueba" + i;
	}
}
