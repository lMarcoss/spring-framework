package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.constant.ViewConstant;
import com.leo.model.UserCredentials;

@Controller
public class LoginController {

	private static final Log log = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		log.info(":::: redirect /login");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		log.info(":::: show form login :::\nparam: \nerror = " + error + "\nlogout = " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		return ViewConstant.LOGIN;
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredentials userCredentials) {
		log.info("::: login-check");
		log.info("Param: userCredentials = " + userCredentials);
		if (userCredentials.getUserName().equals("user") && userCredentials.getPassword().equals("user")) {
			return ViewConstant.CONTACTS;
		} else {
			return "redirect:/login?error";
		}
	}
}
