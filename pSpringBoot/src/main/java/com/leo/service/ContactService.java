package com.leo.service;

import java.util.List;

import com.leo.entity.Contact;

public interface ContactService {
	// // CRUD - create-read-update-delete
	public Contact addContact(Contact contact);

	public List<Contact> listAllContact();

	public Contact updateContact(Contact contact);

	public int removeContact(int id);

	public Contact findContact(int id);

}
