package com.wherehouse.members.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wherehouse.members.service.MemberJoinService;

@Controller
public class MembersJoinController {
	
	@Autowired
	MemberJoinService memberjoinService;
	
	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public String joinRequest(HttpServletRequest httpRequest, Model model) {
//		System.out.println("joinOk  �޼ҵ� ����");
		
		String resInt = String.valueOf(memberjoinService.ValidJoin(httpRequest));

		model.addAttribute("resInt", resInt);
		
		return "members/joinOk";
	}
}