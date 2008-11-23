package com.tikal.popup;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import com.tikal.model.Person;
import com.tikal.pages.EditPersonPage;

public class EditPersonModalWindow extends ModalWindow {
	private static final long serialVersionUID = 1669165776165770041L;

	public EditPersonModalWindow(String id, final Person person,
			final Component initiator) {
		super(id);
		setInitialWidth(550);
		setInitialHeight(450);
		setResizable(false);
		setCssClassName(ModalWindow.CSS_CLASS_GRAY);
		Model[] params =
				new Model[] { new Model(String.valueOf(person.getId())) };
		setTitle(new StringResourceModel("EditPerson.title", this, null, params)); // 10.
		// b
		setPageCreator(new ModalWindow.PageCreator() {
			private static final long serialVersionUID = 1L;

			public Page createPage() {
				return new EditPersonPage(person, EditPersonModalWindow.this);
			}
		});
		setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
			private static final long serialVersionUID = 1L;

			public void onClose(AjaxRequestTarget target) {
				target.addComponent(initiator);
			}
		});
		setCloseButtonCallback(new ModalWindow.CloseButtonCallback() {
			private static final long serialVersionUID = 1L;

			public boolean onCloseButtonClicked(AjaxRequestTarget target) {
				return true;
			}
		});
	}

}
