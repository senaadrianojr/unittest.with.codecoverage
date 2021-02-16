package com.unittest.codecoverage.model.validators;

import com.unittest.codecoverage.exceptions.PersonException;

public class PersonValidator {
	
	public static void firstnameMinLength(String firstname) {
		if(firstname == null || firstname.isBlank() || firstname.trim().length() < 3) {
			throw new PersonException("firstname min length is 03 characteres");
		}
	}
	
	public static void firstnameMaxLength(String firstname) {
		if(firstname != null && !firstname.isBlank() && firstname.trim().length() > 25) {
			throw new PersonException("firstname max length is 25 characteres");
		}
	}

}
