package com.wherehouse.members.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wherehouse.members.service.MembersEditPageService;
import com.wherehouse.members.service.MembersEditService;

@Controller
public class MembersEditController {

	@Autowired
	MembersEditPageService membersEditPageService;
	@Autowired
	MembersEditService membersEditService;
	
	@RequestMapping(value="/membermodifypage", method=RequestMethod.POST)
	public String modifiMember(HttpServletRequest httpRequest, Model model) {
//		System.out.println("modifipag 메소드 실행");
		
		model.addAttribute("MembersVO", membersEditPageService.searchEditMember(httpRequest));
		
		return "members/modify";
	}
	
	@RequestMapping(value="/membermodifyok", method=RequestMethod.POST)
	public String editMember(HttpServletRequest httpRequest, Model model) {
//		System.out.println("editMember 메소드 실행");
		
		
		model.addAttribute("ri", membersEditService.editMember(httpRequest));
		
		return "members/modifyOk";
	}
	
	
}