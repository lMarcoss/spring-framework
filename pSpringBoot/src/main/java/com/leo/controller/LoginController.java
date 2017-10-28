package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.model.UserCredentials;

@Controller
public class LoginController {

	private static final String LOGIN = "login";
	private static final String CONTACTOS = "contacts";

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		return LOGIN;
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredentials userCredentials) {
		if (userCredentials.getUserName().equals("user") && userCredentials.getPassword().equals("user")) {
			return CONTACTOS;
		} else {
			return "redirect:/login?error";
		}
	}
}
