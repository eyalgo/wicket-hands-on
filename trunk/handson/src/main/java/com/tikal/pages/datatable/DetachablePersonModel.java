package com.tikal.pages.datatable;

import org.apache.wicket.model.LoadableDetachableModel;

import com.tikal.db.DaoLocator;
import com.tikal.db.PersonDAO;
import com.tikal.model.Person;

public class DetachablePersonModel extends LoadableDetachableModel { //12.e
	private static final long serialVersionUID = 7032745802083735486L;
	private final int id;

	public DetachablePersonModel(int id) {
		if (id == 0) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	public DetachablePersonModel(Person person) {
		this(person.getId());
	}

	private PersonDAO getPersonDao() {
		return DaoLocator.getDao();
	}

	@Override
	protected Object load() {
		return getPersonDao().get(id);
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof DetachablePersonModel) {
			DetachablePersonModel other = (DetachablePersonModel) obj;
			return other.id == id;
		}
		return false;
	}

}
