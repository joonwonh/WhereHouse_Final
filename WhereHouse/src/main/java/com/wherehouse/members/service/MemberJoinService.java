package com.wherehouse.members.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.members.dao.MembersRepository;

@Service
public class MemberJoinService implements IMemberJoinService {
	
	@Autowired
	MembersRepository membersRepository;
	
	@Override
	public int ValidJoin(HttpServletRequest httpRequest) {
	
		Map <String, String> requestData = new HashMap<String, String>();
		
		requestData.put("id", httpRequest.getParameter("id"));
		requestData.put("pw", httpRequest.getParameter("pw"));
		requestData.put("nickName", httpRequest.getParameter("nickName"));
		requestData.put("tel", httpRequest.getParameter("tel"));
		requestData.put("email", httpRequest.getParameter("email"));
		
		if(membersRepository.confimMember(httpRequest.getParameter("id")) >= 1) {
			
			return 1;
		} 
		else {	
			return membersRepository.addMember(requestData);
		}
	}
}