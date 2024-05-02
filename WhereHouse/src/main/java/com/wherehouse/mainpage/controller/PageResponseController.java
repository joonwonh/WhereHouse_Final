package com.wherehouse.mainpage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wherehouse.board.service.IBoardListService;

@Controller
@RequestMapping(value="/page")
public class PageResponseController  {
	
	@Autowired
	IBoardListService boardListService;
	
	// main.jsp
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String pageMain() {
//		System.out.println("메인페이지 메소드 실행");
		return "recommand/main";
	}
	
	// house_rec.jsp
	@RequestMapping(value="/houserec", method=RequestMethod.GET)
	public String pageHouserec() {
//		System.out.println(("거주지추천페이지 메소드 실행"));
		return "recommand/house_rec";
	}
	
	// gu_map.jsp
	@RequestMapping(value="/gumap", method=RequestMethod.GET)
	public String pageGumap() {
//		System.out.println(("지역구정보페이지 메소드 실행"));
		return "recommand/gu_map";
	}
	
	// 초기 list.jsp
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String pageList(Model model) {
//		System.out.println("상세정보페이지 메소드 실행");
		
		Map<String, Object> listView = boardListService.searchBoard(0);
		
		model.addAttribute("pnSize", listView.get("pnSize"));
		model.addAttribute("boardList", listView.get("boardList"));
		model.addAttribute("members", listView.get("members"));

		return "board/list";
	}
	
	// login.jsp
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String pageLogin() {
//		System.out.println("로그인 메소드 실행");
		
		return "members/login";
	}
	
	// join.jsp
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String pageJoin() {
//		System.out.println("회원가입 메소드 실행");
		
		return "members/join";
	}
	

}