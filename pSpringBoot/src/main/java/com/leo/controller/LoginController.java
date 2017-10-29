package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log log = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		log.info("-> show form login :::\nparam: \nerror = " + error + "\nlogout = " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewConstant.LOGIN;
	}

	@GetMapping({ "/loginSuccess", "/" })
	public String loginCheck() {
		log.info("-> login-check ");
		return "redirect:/contacts/contacts";
	}
}
