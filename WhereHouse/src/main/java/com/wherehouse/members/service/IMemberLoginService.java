package com.wherehouse.members.service;

import javax.servlet.http.HttpServletRequest;

public interface IMemberLoginService {

	public String ValidLoginCheck(String id, String pw, HttpServletRequest httpRequest); 
}
