package com.wherehouse.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wherehouse.board.model.BoardVO;
import com.wherehouse.board.model.CommentVO;

public interface IBoardRepository {
	
	public HashMap<String, Object> SearchBoardList(int pnIndex);	
	public void boardWrite(Object [] parameter);	
	public BoardVO boardView(int boardId);								// 게시판 Id로 선택
	public ArrayList<String> getMembers(ArrayList<String> userId);
	public void upHit(int boardId);	
	public void boardDelete(String boardId);
	public void boardModify(Object [] boardEdit);
	public void replyWrite(Object [] replyParameter);
	public List<CommentVO> commentSearch(int commentId);		
	
}
