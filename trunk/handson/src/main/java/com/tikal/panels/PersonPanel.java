package com.tikal.panels;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import com.tikal.model.Person;
import com.tikal.model.Person.Gender;
import com.tikal.utils.GeneralFactory;

public class PersonPanel extends Panel {
	private static final long serialVersionUID = -478823237632836314L;

	public PersonPanel(String id, Person person) {
		this(id, person, false);
	}

	public PersonPanel(String id, Person person, boolean edit) {
		super(id, new CompoundPropertyModel(person)); // 9.a
		add(new Label("idLabel", "ID").add(new RequiredAttributeModifier())); // 9.
		// b
		add(new Label("firstNameLabel", "First Name")
				.add(new RequiredAttributeModifier()));
		add(new Label("lastNameLabel", "Last Name")
				.add(new RequiredAttributeModifier()));
		add(new Label("genderLabel", "Gender")
				.add(new RequiredAttributeModifier()));
		add(new Label("countryLabel", "Country")
				.add(new RequiredAttributeModifier()));
		add(new Label("cityLabel", "City"));
		add(new Label("streetLabel", "Street"));
		add(new Label("addressLabel", "Address"));
		add(new Label("zipLabel", "ZIP"));
		add(new Label("birthDayLabel", "Day of birth"));
		add(new Label("birthMonthLabel", "Month of birth"));
		add(new Label("birthYearLabel", "Year of Birth")
				.add(new RequiredAttributeModifier()));
		add(new Label("joinDateLabel", "Join Date")
				.add(new RequiredAttributeModifier()));

		TextField textFieldId = new TextField("id");
		textFieldId.setRequired(true);
		if (edit) { // 10.d
			textFieldId.setEnabled(false);
		}
		add(textFieldId);
		add(new TextField("firstName").setRequired(true));
		add(new TextField("lastName").setRequired(true));
		// 9.c
		final List<Gender> genders = Arrays.asList(Gender.values());
		final ChoiceRenderer genderRenderer =
				new ChoiceRenderer("displayName", "name");
		add(new RadioChoice("gender", genders, genderRenderer)
				.setRequired(true));
		add(new TextField("country").setRequired(true));
		add(new TextField("city"));
		add(new TextField("street"));
		add(new TextField("address"));
		add(new TextField("zip"));
		add(new DropDownChoice("birthDay", GeneralFactory.createDayRange()));
		add(new DropDownChoice("birthMonth", GeneralFactory.createMonthsRange()));
		add(new DropDownChoice("birthYear", GeneralFactory.createYearsRange())
				.setRequired(true));
		final DateTextField joinDate =
				new DateTextField("joinDate", GeneralFactory.getDatePattern()); // 9.e
		joinDate.add(new DatePicker());
		joinDate.setRequired(true);
		add(joinDate);
		add(new FeedbackPanel("feedback"));
	}

	// 9.b
	private final static class RequiredAttributeModifier extends
			AttributeModifier {
		private static final long serialVersionUID = 1L;

		public RequiredAttributeModifier() {
			super("style", true, new Model("color:red"));
		}
	}
}
