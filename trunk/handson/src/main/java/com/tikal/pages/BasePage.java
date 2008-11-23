package com.tikal.pages;

import org.apache.wicket.markup.html.WebPage;

import com.tikal.db.DaoLocator;
import com.tikal.db.PersonDAO;

public class BasePage extends WebPage {
	protected PersonDAO getPersonDao() {
		return DaoLocator.getDao();
	}
}
