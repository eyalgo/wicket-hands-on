package com.tikal.pages.datatable;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.tikal.db.DaoLocator;
import com.tikal.db.PersonDAO;
import com.tikal.model.Person;

class SortablePersonsDataProvider extends SortableDataProvider {
	private static final long serialVersionUID = 1L;

	SortablePersonsDataProvider() {
		setSort("lastName", true);
	}

	private PersonDAO getPersonDao() {
		return DaoLocator.getDao();
	}

	public Iterator<Person> iterator(int first, int count) {
		final SortParam sp = getSort();
		return getPersonDao().find(first, count, sp.getProperty(),
				sp.isAscending()).iterator();
	}

	public IModel model(final Object object) { // 12.e
		return new DetachablePersonModel((Person)object);
	}

	public int size() {
		return getPersonDao().getCount();
	}

}
