package com.leo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.constant.ViewConstant;
import com.leo.entity.Contact;
import com.leo.service.ContactService;

@Controller
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
@RequestMapping("/contacts")
public class ContactController {
	private static final Log log = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	// @PreAuthorize("hasRole('ROLE_USER')") // también puede ser a nivel de
	// clase --> ver ejemplo en el servicio : contactServiceImplvicio
	@GetMapping("/contactForm")
	public String contactForm(Model model) {
		log.info(":::: Redirect contact form");
		model.addAttribute("action", "/contacts/addContact");
		model.addAttribute("contact", new Contact());
		return showContactForm(model);
	}

	@GetMapping("/showContactForm")
	public String showContactForm(Model model) {
		log.info("--> Show contact form \nParam " + model);
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addContact")
	public String addContact(@ModelAttribute(name = "contact") Contact contact, Model model) {
		log.info("-> Add contact: \nParam " + contact.toString());
		if (contactService.addContact(contact) != null) {
			model.addAttribute("message", "contact added successfully");
			model.addAttribute("error", 0);
		} else {
			model.addAttribute("message", "error adding contact");
			model.addAttribute("error", 1);
		}
		return contacts(model);
	}

	@GetMapping("/contacts")
	public String contacts(Model model) {
		// User de spring -- obtener usuario en sesión
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername());
		// send list contacts in the view
		model.addAttribute("contacts", contactService.listAllContact());
		return ViewConstant.CONTACTS;
	}

	// localhost:8080/contacts/editContact?id=1
	@GetMapping("/editContact")
	public String editContact(@RequestParam(name = "id") int id, Model model) {
		log.info("-> edit Course \nParam id = " + id);
		model.addAttribute("action", "/contacts/updateContact");
		model.addAttribute("contact", contactService.findContact(id));
		return showContactForm(model);
	}

	@PostMapping("/updateContact")
	public String updateContact(@ModelAttribute(name = "contact") Contact contact, Model model) {
		log.info("-> update contact: \nParam " + contact.toString());
		if (contactService.updateContact(contact) != null) {
			model.addAttribute("message", "contact updated successfuly");
			model.addAttribute("error", 0);
		} else {
			model.addAttribute("message", "error updating contact");
			model.addAttribute("error", 1);
		}
		return contacts(model);
	}

	// localhost:8080/contacts/removeContact/1
	@GetMapping("/removeContact/{id}")
	public String removeContact(@PathVariable("id") int id) {
		log.info("-> Remove contact \nParam = " + id);
		contactService.removeContact(id);
		return "redirect:/contacts/contacts";
	}

	@GetMapping("/cancel")
	public String redirectContacts() {
		return "redirect:/contacts/contacts";
	}
}
