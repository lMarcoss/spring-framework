package com.leo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.entity.Contact;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	// Regresamos un dato de tipo JSON
	@GetMapping("/checkRest")
	public ResponseEntity<Contact> checkRest() {
		Contact contact = new Contact(1, "Sara", "Te amo", "487923894729", "Oaxaca");
		// return new ResponseEntity<String>("OK!", HttpStatus.OK); --> devuelve el string "OK!"
		// devuelve el objeto Contact
		return new ResponseEntity<Contact>(contact, HttpStatus.OK); 
	}
}
