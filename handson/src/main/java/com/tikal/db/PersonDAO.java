package com.tikal.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.tikal.model.Person;

public final class PersonDAO {
	private final SortedMap<Integer, Person> persons;

	public PersonDAO() {
		persons = new TreeMap<Integer, Person>();
		persons.putAll(PersonGenerator.createMocks());
	}

	/**
	 * @return number of contacts in the database
	 */
	public int getCount() {
		return persons.size();
	}

	/**
	 * Collection of the persons in the DB
	 * 
	 * @return Collection<Person>
	 */
	public Collection<Person> getPersons() {
		return persons.values();
	}

	/**
	 * 
	 * @param id
	 * @return Person by ID
	 */
	public Person get(int id) {
		return persons.get(Integer.valueOf(id));
	}

	/**
	 * 
	 * @param person
	 * @throws RuntimeException
	 *             if person with the same ID already exists
	 */
	public void addPerson(Person person) {
		if (persons.containsKey(person.getId())) {
			throw new RuntimeException("Person with ID " + person.getId()
					+ " already exists");
		} else {
			persons.put(person.getId(), person);
		}
	}

	/**
	 * Removes the person (by ID) from the map
	 * 
	 * @param id
	 */
	public void removePerson(Integer id) {
		persons.remove(id);
	}

	/**
	 * 
	 * Removes this person from the database.
	 * 
	 * @param person
	 */
	public void removePerson(Person person) {
		removePerson(person.getId());
	}

	/**
	 * Updates the person in the map
	 * 
	 * @param person
	 */
	public void updatePerson(Person person) {
		persons.remove(person.getId());
		addPerson(person);
	}

	public List<Person> find(int first, int count, String sortProperty,
			boolean sortAsc) {
		List<Person> orderedByProp = orderByProp(sortProperty);
		if (!sortAsc) {
			Collections.reverse(orderedByProp);
		}
		return orderedByProp.subList(first, first + count);
	}

	private List<Person> orderByProp(String prop) {
		final List<Person> values = new ArrayList<Person>(persons.values());
		if (prop == null) {
			return new ArrayList<Person>(values);
		}

		if (prop.equals("id")) {
			return values;
		} else if (prop.equals("firstName")) {
			Collections.sort(values, new Comparator<Person>() {
				public int compare(Person arg0, Person arg1) {
					return (arg0).getFirstName().compareTo(
							(arg1).getFirstName());
				}
			});
		} else if (prop.equals("lastName")) {
			Collections.sort(values, new Comparator<Person>() {
				public int compare(Person arg0, Person arg1) {
					return (arg0).getLastName().compareTo(
							(arg1).getLastName());
				}
			});
		} else if (prop.equals("birthYear")) {
			Collections.sort(values, new Comparator<Person>() {
				public int compare(Person arg0, Person arg1) {
					return (arg0).getBirthYear().compareTo(
							(arg1).getBirthYear());
				}
			});
			
		} else {
			throw new RuntimeException(
					"uknown sort option ["
							+ prop
							+ "]. valid options: [id] , [firstName] , [lastName] , [birthYear]");
		}
		return values;
	}
}
