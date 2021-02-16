package com.unittest.codecoverage.services;

import com.unittest.codecoverage.models.Person;

public interface PersonService {
	
	public Person create(Person person);
	
	public void update(Person person);
	
	public Person getById(Long id);

}
