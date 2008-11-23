package com.tikal.model;

import java.io.Serializable;
import java.util.Date;

import com.tikal.WicketHandsOnApplication;
import com.tikal.utils.GeneralFactory;

public final class Person implements Serializable {
	private static final long serialVersionUID = 7529695595255035976L;

	public enum Gender {
		MALE, FEMALE;

		public final String getDisplayName() { // 9.d
			return WicketHandsOnApplication.get().getResourceSettings()
					.getLocalizer().getString("Gender." + name(), null);
		}
	}

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer birthYear;
	private Integer birthMonth;
	private Integer birthDay;
	private String street;
	private String address;
	private String city;
	private String country;
	private Integer zip;
	private Gender gender;
	private Date joinDate = new Date();

	public Person() {
		super();
	}

	public Person(Integer id, String firstName, String lastName, Gender gender,
			String country, String city, String street, String address,
			Integer zip, Integer birthDay, Integer birthMonth, Integer birthYear) {
		super();
		this.address = address;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.city = city;
		this.country = country;
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.street = street;
		this.zip = zip;
		this.gender = gender;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final Integer getBirthYear() {
		return birthYear;
	}

	public final void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public final Integer getBirthMonth() {
		return birthMonth;
	}

	public final void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	public final Integer getBirthDay() {
		return birthDay;
	}

	public final void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	public final String getStreet() {
		return street;
	}

	public final void setStreet(String street) {
		this.street = street;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	public final Integer getZip() {
		return zip;
	}

	public final void setZip(Integer zip) {
		this.zip = zip;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Gender getGender() {
		return gender;
	}

	public final void setGender(Gender gender) {
		this.gender = gender;
	}

	public final Date getJoinDate() {
		return joinDate;
	}

	public final void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[Person: ");
		builder.append("ID=" + id);
		builder.append(" lastName=" + lastName);
		builder.append(" firstName=" + firstName);
		builder.append(" gender=" + gender.getDisplayName());
		builder.append(" country=" + country);
		builder.append(" city=" + city);
		builder.append(" street=" + street);
		builder.append(" address=" + address);
		builder.append(" zip=" + zip);
		builder.append(" birthDay=" + birthDay);
		builder.append(" birthMonth=" + birthMonth);
		builder.append(" birthYear=" + birthYear);
		builder.append(" joinDate="
				+ GeneralFactory.getDateFormat().format(joinDate));
		builder.append("]");
		return builder.toString();
	}

}
