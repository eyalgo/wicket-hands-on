package com.tikal.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends WebPage {
	private String userId = "";
	private String password = "";

	public LoginPage() {
		Form form = new Form("form");
		add(form);
		form.add(new Label("userIdLabel", "User ID"));
		form.add(new Label("passwordLabel", new Model("Password")));
		form.add(new TextField("userId", new PropertyModel(this, "userId"))
				.setRequired(true));
		TextField passField =
				new PasswordTextField("password", new PropertyModel(this,
						"password"));
		form.add(passField);
		form.add(new Button("login", new Model("Login")) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				System.out // 3.c
						.println("userId=" + userId + " password=" + password);
//				info("userId=" + userId + " password=" + password); // 3.e
//				HandsOnSession.get().setUserId(userId); // 4.a
//				HandsOnSession.get().setPassword(password); // 4.a
//				setResponsePage(PersonListPage.class); // 5
			}
		});

		FeedbackPanel feedback = new FeedbackPanel("feedback");
		add(feedback);
	}
}
