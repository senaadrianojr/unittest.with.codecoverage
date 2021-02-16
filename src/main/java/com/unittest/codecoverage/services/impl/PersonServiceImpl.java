package com.unittest.codecoverage.services.impl;

import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import com.unittest.codecoverage.services.PersonService;

public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void update(Person person) {
		personRepository.save(person);
	}

	@Override
	public Person getById(Long id) {
		return personRepository.getOne(id);
	}

}
