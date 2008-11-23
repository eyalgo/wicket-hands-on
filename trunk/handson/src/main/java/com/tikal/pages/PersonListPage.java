package com.tikal.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;

import com.tikal.model.Person;
import com.tikal.pages.datatable.PeopleTablePage;
import com.tikal.popup.EditPersonModalWindow;
import com.tikal.utils.GeneralFactory;

public class PersonListPage extends BasePage {
	public PersonListPage() {
		// Container is for the ajax update (section 10.a)
		final WebMarkupContainer container =
				new WebMarkupContainer("container");
		add(container);

		container.add(new ListView("persons",
				new PropertyModel(this, "persons")) {// 6
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem item) {
						Person person = (Person) item.getModelObject();
						item
								.add(new Label("id", String.valueOf(person
										.getId())));
						item.add(new Label("firstName", person.getFirstName()));
						item.add(new Label("lastName", person.getLastName()));
						item.add(new Label("gender", person.getGender()
								.getDisplayName()));
						item.add(new Label("country", person.getCountry()));
						item.add(new Label("birthDate",
								generateBirthDate(person)));
						item.add(new Label("joinDate", GeneralFactory
								.getDateFormat().format(person.getJoinDate())));
						item.add(new Link("remove", item.getModel()) {
							private static final long serialVersionUID = 1L;

							@Override
							public void onClick() {
								Person person = (Person) getModelObject();
								getPersonDao().removePerson(person);
							}
						});

						final EditPersonModalWindow editPersonModalWindow =
								new EditPersonModalWindow("popup", person,
										container);
						item.add(new AjaxFallbackLink("edit", item.getModel()) { // 10
									private static final long serialVersionUID =
											1L;

									@Override
									public void onClick(AjaxRequestTarget target) {
										editPersonModalWindow.show(target);
									}
								});
						item.add(editPersonModalWindow);
					}
				});
		container.setOutputMarkupId(true); // 10.a
		// 10
		Link addLink = new BookmarkablePageLink("add", AddPersonPage.class);
		addLink.add(new Label("addLabel", "Add Person"));
		add(addLink);
		Link showTable =
				new BookmarkablePageLink("showTable", PeopleTablePage.class) {
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isVisible() { // 12.a
						return getPersons().size() > 5;
					}
				};
		add(showTable);
	}

	private String generateBirthDate(Person person) {
		return String.valueOf(person.getBirthYear());
	}

	/**
	 * This is for the PropertyModel that is used in the ListView (6.b)
	 * 
	 * @return List<Person>
	 */
	public List<Person> getPersons() {
		return Collections.unmodifiableList(new ArrayList<Person>(
				getPersonDao().getPersons()));
	}

}
