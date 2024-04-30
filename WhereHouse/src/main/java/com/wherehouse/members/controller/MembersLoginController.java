package com.wherehouse.members.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.wherehouse.members.service.MemberLoginService;
import com.wherehouse.members.service.MemberLogoutService;

@Controller
public class MembersLoginController {

	@Autowired
	MemberLoginService memberLoginService;
	@Autowired
	MemberLogoutService memberLogoutService;
	
	@RequestMapping(value="/loginOk", method=RequestMethod.GET)
	public String checkLogin(@RequestParam String id, @RequestParam String pw, Model model, HttpServletRequest httpRequest) {
		System.out.println("checkLogin  메소드 실행");
		
		model.addAttribute("loginRes", memberLoginService.ValidLoginCheck(id, pw, httpRequest));
		return "members/loginOk";
	}
	
	@RequestMapping(value="/loginSuccess", method=RequestMethod.GET)
	public String redirectLoginSueccess() {
		System.out.println("redirectLoginSueccess  메소드 실행");
		
		return "members/loginSuccess"; 
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String pageLogout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		System.out.println("pageLogout 메소드 실행");
		
		memberLogoutService.executeLogout(httpRequest);
		
		return "members/logout";
	}
}