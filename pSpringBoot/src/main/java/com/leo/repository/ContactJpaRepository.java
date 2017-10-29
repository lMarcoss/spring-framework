package com.leo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.entity.Contact;

@Repository("contactJpaRepository")
public interface ContactJpaRepository extends JpaRepository<Contact, Serializable> {
	public Contact findById(int id);

}
