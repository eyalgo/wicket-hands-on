package com.tikal.pages.datatable;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import com.tikal.pages.BasePage;
import com.tikal.pages.PersonListPage;

public class PeopleTablePage extends BasePage {
	public PeopleTablePage() {
		add(HeaderContributor.forCss("/style/style.css")); // 12.c
		// add(HeaderContributor.forCss(new ResourceReference(
		// PeopleTablePage.class, "style.css")));
		List<IColumn> columns = new ArrayList<IColumn>();
		columns.add(new PropertyColumn(new Model("ID"), "id"/* , "id" 12.f */) {
			private static final long serialVersionUID = 1L;

			@Override
			public String getCssClass() {
				return "numeric";
			}
		});
		columns.add(new PropertyColumn(new Model("First Name"), "firstName",
				"firstName"));

		columns.add(new PropertyColumn(new Model("Last Name"), "lastName",
				"lastName") {
			private static final long serialVersionUID = 1L;

			@Override
			public String getCssClass() {
				return "last-name";
			}
		});
		columns.add(new PropertyColumn(new Model("Birth Year"), "birthYear",
				"birthYear") {
			private static final long serialVersionUID = 1L;

			@Override
			public String getCssClass() {
				return "numeric";
			}
		});
		columns.add(new PropertyColumn(new Model("Join Date"), "joinDate"));
		add(new DefaultDataTable /* AjaxFallbackDefaultDataTable 12.g */(
				"table", columns, new SortablePersonsDataProvider(), 8));
		Link back = new Link("back") { // 12.d
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(PersonListPage.class);
					}
				};
		add(back);
	}
}
