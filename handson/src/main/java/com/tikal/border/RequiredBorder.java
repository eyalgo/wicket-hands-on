package com.tikal.border;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.border.MarkupComponentBorder;
import org.apache.wicket.markup.html.form.FormComponent;

public final class RequiredBorder extends MarkupComponentBorder {
	private static final long serialVersionUID = -589069922900558289L;
	@Override
	public void renderAfter(Component component) {
		FormComponent fc = (FormComponent) component;
		if (fc.isRequired()) {
			super.renderAfter(component);
		}
	}
}
