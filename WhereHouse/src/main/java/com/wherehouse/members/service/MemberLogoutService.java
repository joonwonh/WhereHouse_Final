package com.wherehouse.members.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutService implements IMemberLogoutService{

	@Override
	public void executeLogout(HttpServletRequest httpRequest) {
		HttpSession session = httpRequest.getSession() ;
		session.invalidate();
	}
}