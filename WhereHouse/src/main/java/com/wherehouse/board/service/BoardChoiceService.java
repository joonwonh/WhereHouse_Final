package com.wherehouse.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.board.dao.BoardRepository;
import com.wherehouse.board.model.BoardVO;


@Service
public class BoardChoiceService implements IBoardChoiceService{

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Map<String, Object> sarchView(int contentnum) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		boardRepository.upHit(contentnum);
		
		 BoardVO boardVO = boardRepository.boardView(contentnum);
		resultMap.put("content_view", boardVO);
		
		resultMap.put("comments", boardRepository.commentSearch(contentnum)) ;
		
		ArrayList<String> userId  = new ArrayList<String>();
		userId.add(String.valueOf(boardVO.getuserid()));
		resultMap.put("nickname", boardRepository.getMembers(userId)) ;
		
		return resultMap;
	}
}