package com.tikal.pages;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;

import com.tikal.model.Person;
import com.tikal.panels.PersonPanel;

public class EditPersonPage extends BasePage {
	private static Logger log = Logger.getLogger(EditPersonPage.class);
	public EditPersonPage(final Person person, final ModalWindow window) {
		PersonPanel panel = new PersonPanel("panel", person, true);
		Form form = new Form("form");
		add(form);
		form.add(panel);
		form.add(new AjaxButton("ok") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit(AjaxRequestTarget target, Form form) {
				getPersonDao().updatePerson(person);
				log.info("Update Person=" + person);
				window.close(target);
			}
		});
		AjaxButton cancelButton = new AjaxButton("cancel") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form form) {
				window.close(target);
			}
		};
		cancelButton.setDefaultFormProcessing(false);
		form.add(cancelButton); 
	}
}
