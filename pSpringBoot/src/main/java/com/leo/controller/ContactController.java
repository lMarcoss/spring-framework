package com.leo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.constant.ViewConstant;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	private static final Log log = LogFactory.getLog(ContactController.class);

	@GetMapping("/contactForm")
	public String redirectContactForm() {
		log.info(":::: Redirect contact form");
		return ViewConstant.CONTACT_FORM;
	}
}
