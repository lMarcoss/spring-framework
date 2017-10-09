package com.leo.service.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.leo.model.Person;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			people.add(new Person("person_" + i, i + 20));
		}
		LOG.info("Hello! from Service");
		return people;
	}

}
