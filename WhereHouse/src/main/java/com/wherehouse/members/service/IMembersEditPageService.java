package com.wherehouse.members.service;

import javax.servlet.http.HttpServletRequest;

import com.wherehouse.members.model.MembersVO;

public interface IMembersEditPageService {
	
	public MembersVO searchEditMember(HttpServletRequest httpRequest);
}