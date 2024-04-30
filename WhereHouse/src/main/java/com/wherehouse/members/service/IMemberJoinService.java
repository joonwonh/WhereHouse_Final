package com.wherehouse.members.service;

import javax.servlet.http.HttpServletRequest;


public interface IMemberJoinService {
	
	public int ValidJoin(HttpServletRequest httpRequest);
}