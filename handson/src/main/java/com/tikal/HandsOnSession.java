package com.tikal;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

public final class HandsOnSession extends WebSession {
	private static final long serialVersionUID = 7913250490890527413L;
	private String userId;
	private String password;

	public static HandsOnSession get() {
		return (HandsOnSession) Session.get();
	}

	public HandsOnSession(Request request) {
		super(request);
	}
	
	public final String getUserId() {
		return userId;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}
}
