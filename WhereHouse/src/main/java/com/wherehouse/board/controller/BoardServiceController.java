package com.wherehouse.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wherehouse.board.service.BoardChoiceService;
import com.wherehouse.board.service.BoardDeleteService;
import com.wherehouse.board.service.BoardListService;
import com.wherehouse.board.service.BoardModifyService;
import com.wherehouse.board.service.BoardWriteCommand;
import com.wherehouse.board.service.BoardWriteService;

@Controller
public class BoardServiceController {
	
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardChoiceService boardChoiceService;
	@Autowired
	BoardDeleteService boardDeleteService;
	@Autowired
	BoardModifyService boardModifyService;
	@Autowired
	BoardWriteCommand boardWriteCommand;
	
	@RequestMapping(value="/list/{pnIndex}", method=RequestMethod.GET)
	public String pageListPn(@PathVariable int pnIndex, Model model) {
//		System.out.println("pageListPn 메소드 실행");
		
		Map<String, Object> listView = boardListService.searchBoard(pnIndex);
		
		model.addAttribute("pnSize", listView.get("pnSize"));
		model.addAttribute("boardList", listView.get("boardList"));
		model.addAttribute("members", listView.get("members"));
		
		return "board/list";
	}
	
	@RequestMapping(value="/writepage", method=RequestMethod.GET)
	public String WritePage() {
//		System.out.println("Writepage  메소드 실행");
		
		return "board/writepage";	
	}
	
	@RequestMapping(value="/writeboard", method=RequestMethod.POST)
	public String WritePage(HttpServletRequest httpRequest, Model model) {
//		System.out.println("Writepage 메소드 실행");
		
		boardWriteService.boardWrite(httpRequest);
		
		return "redirect:/page/list";
	}
	
	@RequestMapping(value="/writeboard/{contentnum}", method=RequestMethod.GET)
	public String writePage(@PathVariable int contentnum, Model model) {
//		System.out.println("writeboard 메소드 실행");
		
		Map<String, Object> contentView = boardChoiceService.sarchView(contentnum);
		
		model.addAttribute("content_view", contentView.get("content_view"));
		model.addAttribute("comments", contentView.get("comments"));
		model.addAttribute("nickname", contentView.get("nickname"));
		
		return "board/contentview";
	}
	
	@RequestMapping(value="/delete/{contentnum}", method=RequestMethod.GET)
	public String deletePage(@PathVariable String contentnum) {
		
		boardDeleteService.deleteBoard(contentnum);
		
		return "redirect:/page/list";		
	}
	
	@RequestMapping(value="/modifypage", method=RequestMethod.POST)
	public String modifiyPageRequest(HttpServletRequest httpRequest, Model model) {
		
		model.addAttribute("bId", httpRequest.getParameter("bId"));
		model.addAttribute("title", httpRequest.getParameter("title"));
		model.addAttribute("boardDate", httpRequest.getParameter("boardDate"));
		model.addAttribute("boardHit", httpRequest.getParameter("boardHit"));
		model.addAttribute("boardContent", httpRequest.getParameter("boardContent"));
		
		return "board/contentedit";		
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPage(HttpServletRequest httpRequest) {
//		System.out.println("modifiy 메소드 실행");
		
		boardModifyService.modifyBoard(httpRequest);
		
		return "redirect:/page/list";
	}
	
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	public String replyWrite(HttpServletRequest httpRequest) {
//		System.out.println("replyWrite 메소드 실행");
		
		boardWriteCommand.writeReply(httpRequest);
		
		String redir = "redirect:/writeboard/" + httpRequest.getParameter("bId");
		
		return redir;
	}
}
