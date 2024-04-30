package com.wherehouse.members.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.members.dao.MembersRepository;
import com.wherehouse.members.model.MembersVO;

@Service
public class MembersEditPageService implements IMembersEditPageService {

	@Autowired
	MembersRepository membersRepository;
	
	@Override
	public MembersVO searchEditMember(HttpServletRequest httpRequest) {
		
		return membersRepository.getMember(httpRequest.getParameter("editid"));		
	}
}
