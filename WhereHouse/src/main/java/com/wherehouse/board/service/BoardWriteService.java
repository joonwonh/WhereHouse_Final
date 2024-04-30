package com.wherehouse.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wherehouse.board.dao.BoardRepository;

@Repository
public class BoardWriteService implements IBoardWriteService{
	
	@Autowired
	BoardRepository boardRepository;

	@Override
	public void boardWrite(HttpServletRequest httpRequest) {
		
		Object [] parameters = new Object[4];
		
		parameters[0] = httpRequest.getParameter("id");
		parameters[1] = httpRequest.getParameter("title");
		parameters[2] = httpRequest.getParameter("bcontent");
		parameters[3] = httpRequest.getParameter("regions");
		
		boardRepository.boardWrite(parameters);
	}
}
