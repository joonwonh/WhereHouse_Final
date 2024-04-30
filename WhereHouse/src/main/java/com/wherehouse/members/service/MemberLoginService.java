package com.wherehouse.members.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.members.dao.IMembersRepository;
import com.wherehouse.members.model.MembersVO;

@Service
public class MemberLoginService implements IMemberLoginService{

	@Autowired
	IMembersRepository membersRepository;
	
	@Override
	public String ValidLoginCheck(String id, String pw, HttpServletRequest httpRequest) {
		
		Map<String, Object> resObj = membersRepository.checkMember(id, pw);
		MembersVO membersVO = (MembersVO) resObj.get("membersVO");
		
		if(resObj.get("resInt").equals("1")){
			
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute("id", membersVO.getId());
			httpSession.setAttribute("nickname", membersVO.getNickName());
			httpSession.setAttribute("validMem", "yes");
			
			return "1";
		} 
		else if(resObj.get("resInt").equals("-1"))
			return "-1";
		
		else												 
			return "0";
	}
}