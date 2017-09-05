package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")		// ruta para desplegar el resultado de los métodos de este controlador: ip:8080/say/helloworld
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "helloworld";
	}

}
