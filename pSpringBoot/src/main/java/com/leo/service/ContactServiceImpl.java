package com.leo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.leo.entity.Contact;
import com.leo.repository.ContactJpaRepository;

@PreAuthorize("permitAll()")
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactJpaRepository")
	private ContactJpaRepository contactJpaRepository;

	@Override
	public Contact addContact(Contact contact) {
		return contactJpaRepository.save(contact);
	}

	@Override
	public List<Contact> listAllContact() {
		return contactJpaRepository.findAll();
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactJpaRepository.save(contact);
	}

	@Override
	public int removeContact(int id) {
		contactJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Contact findContact(int id) {
		return contactJpaRepository.findById(id);
	}

}
