package com.tikal;

import org.apache.log4j.Logger;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IExceptionSettings;
import org.apache.wicket.util.time.Duration;

import com.tikal.db.PersonDAO;
import com.tikal.pages.InternalErrorPage;
import com.tikal.pages.PersonListPage;
import com.tikal.pages.datatable.PeopleTablePage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketHandsOnApplication extends WebApplication {
	private static Logger log =
			Logger.getLogger(WicketHandsOnApplication.class);
	private PersonDAO personDao;

	/**
	 * Constructor
	 */
	public WicketHandsOnApplication() {
	}

	@Override
	protected void init() {
		personDao = new PersonDAO();

		// 13
		getApplicationSettings().setInternalErrorPage(InternalErrorPage.class);
		String configurationType = getConfigurationType();
		if (DEVELOPMENT.equalsIgnoreCase(configurationType)) {
			getResourceSettings().setThrowExceptionOnMissingResource(true);
			log.info("You are in DEVELOPMENT mode");
			getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);
			getDebugSettings().setComponentUseCheck(true);
			getMarkupSettings().setStripWicketTags(false);
			getExceptionSettings().setUnexpectedExceptionDisplay( // 13.b
					IExceptionSettings.SHOW_EXCEPTION_PAGE);
			getDebugSettings().setAjaxDebugModeEnabled(true);
		} else if (DEPLOYMENT.equalsIgnoreCase(configurationType)) {
			getResourceSettings().setThrowExceptionOnMissingResource(false);
			getResourceSettings().setResourcePollFrequency(null);
			getDebugSettings().setComponentUseCheck(false);
			getMarkupSettings().setStripWicketTags(true);
			getExceptionSettings().setUnexpectedExceptionDisplay(
					IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
			getDebugSettings().setAjaxDebugModeEnabled(false);
		}
		
		mountBookmarkablePage("/table", PeopleTablePage.class); // 13.c
		mountBookmarkablePage("/list", PersonListPage.class); // 13.c
	}

	public static WicketHandsOnApplication get() {
		return (WicketHandsOnApplication) Application.get();
	}

	/**
	 * @see wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class; // 1
		// return LoginPage.class; // 3
	}

	// @Override
	// // 4
	// public Session newSession(Request request, Response response) {
	// return new HandsOnSession(request);
	// }

	public final PersonDAO getPersonDao() {
		return personDao;
	}
}
