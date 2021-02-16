package com.unittest.codecoverage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unittest.codecoverage.models.Person;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
