package com.wherehouse.members.service;

import javax.servlet.http.HttpServletRequest;

public interface IMemberLogoutService {
	
	public void executeLogout(HttpServletRequest httpRequest);
}
