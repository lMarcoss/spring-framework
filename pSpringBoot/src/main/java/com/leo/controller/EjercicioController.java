package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.leo.service.ejercicio.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	private static Log LOG = LogFactory.getLog(EjercicioController.class);
	private static String EJERCICIO = "ejercicio";

	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;

	@GetMapping("/")
	public RedirectView ejercicioLog() {
		return new RedirectView("/ejercicio/redireccionar");
	}

	@GetMapping("/redireccionar")
	public String ejercicio(Model model) {
		LOG.info("Into the method with path /redireccionar");
		ejercicioService.getMensajeLog();
		model.addAttribute("mensaje", "Message sent to the EjercicioController");
		return EJERCICIO;
	}
}
