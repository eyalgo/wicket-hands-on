package com.tikal.db;

import org.apache.wicket.RequestCycle;

import com.tikal.WicketHandsOnApplication;

public class DaoLocator {

	// Suppress default constructor for noninstantiability
	private DaoLocator() {
		throw new AssertionError("No instance for DaoLocator");
	}
	
	public static PersonDAO getDao() {
		WicketHandsOnApplication app = (WicketHandsOnApplication)RequestCycle.get().getApplication();
        return app.getPersonDao();
	}

}
