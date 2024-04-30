package com.wherehouse.board.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.board.dao.BoardRepository;

@Service
public class BoardListService implements IBoardListService{

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Map<String, Object> searchBoard(int pnIndex) {
		
		return boardRepository.SearchBoardList(pnIndex);
	}
}