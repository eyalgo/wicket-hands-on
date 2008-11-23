package com.tikal.pages;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

import com.tikal.model.Person;
import com.tikal.panels.PersonPanel;

public class AddPersonPage extends BasePage {
	private static Logger log = Logger.getLogger(AddPersonPage.class);

	public AddPersonPage() {
		this(new Person());
	}

	public AddPersonPage(final Person person) {
		PersonPanel panel = new PersonPanel("panel", person);
		Form form = new Form("form");
		add(form);
		form.add(panel);
		form.add(new Button("ok") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				getPersonDao().addPerson(person);
				log.info("Added Person: " + person);
				setResponsePage(PersonListPage.class);
			}
		});
		Button cancelButton = new Button("cancel") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				setResponsePage(PersonListPage.class);
			}
		};
		cancelButton.setDefaultFormProcessing(false);
		form.add(cancelButton);
	}
}
