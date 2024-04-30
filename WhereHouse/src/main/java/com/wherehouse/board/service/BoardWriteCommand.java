package com.wherehouse.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.board.dao.BoardRepository;

@Service
public class BoardWriteCommand implements IBoardWriteCommand{
	
	@Autowired
	BoardRepository boardRepository;

	@Override
	public void writeReply(HttpServletRequest httpRequest) {	
		
		Object[] parameters = new Object[5];
		
		HttpSession session = httpRequest.getSession();
		
		parameters[0] = httpRequest.getParameter("bId");
		parameters[1] = httpRequest.getParameter("sessionId");
		parameters[2] = (String) session.getAttribute("nickname");
		parameters[3] = httpRequest.getParameter("title");
		parameters[4] = httpRequest.getParameter("replyvalue");
		
		boardRepository.replyWrite(parameters);
	}
}
