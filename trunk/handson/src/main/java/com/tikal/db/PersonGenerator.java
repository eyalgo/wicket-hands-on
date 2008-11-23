package com.tikal.db;

import java.util.HashMap;
import java.util.Map;

import com.tikal.model.Person;
import com.tikal.model.Person.Gender;

public final class PersonGenerator {

	private PersonGenerator() {
		// No instance
	}

	public static Map<Integer, Person> createMocks() {
		Map<Integer, Person> persons = new HashMap<Integer, Person>();
		persons.put(1, createPerson(1, "Eyal", "Golan", Gender.MALE, "Israel", "Tivon",
				"Hatzivoni", "POB 2340", 36095, 18, 3, 1974));
		persons.put(2, createPerson(2, "Limor", "Schaham", Gender.FEMALE, "Israel", "Tivon",
				"Hatzivoni", "POB 2340", 36095, 1, 10, 1972));
		return persons;
	}

	private static Person createPerson(Integer id, String firstName,
			String lastName, Gender gender, String country, String city, String street,
			String address, Integer zip, Integer birthDay, Integer birthMonth,
			Integer birthYear) {
		return new Person(id, firstName, lastName, gender, country, city,
				street, address, zip, birthDay, birthMonth, birthYear);

	}

}
