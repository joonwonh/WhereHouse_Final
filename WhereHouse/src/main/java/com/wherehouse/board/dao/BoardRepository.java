/* 源뚭퓤 */
package com.wherehouse.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wherehouse.board.model.BoardVO;
import com.wherehouse.board.model.CommentVO;

@Repository
public class BoardRepository implements IBoardRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public HashMap<String, Object> SearchBoardList(int pnIndex) {
		
		String query = "select * from whereboard order by connum desc";		// 게시글 조회
		
		List<BoardVO> boardAllList = jdbcTemplate.query(query, new BoardVOMapper());		
		List <BoardVO> boardList = new ArrayList<BoardVO>();
		
		ArrayList<String> userId = new ArrayList<String>();	
		
		HashMap<String, Object> resultBoard = new HashMap<String, Object>();	
		
		int pnSize = ((int) Math.ceil(boardAllList.size()/10))+1;
		pnIndex = pnIndex * 10;
		int pnEnd = pnIndex + 9;
		
		for(; pnIndex <= pnEnd && pnIndex < boardAllList.size(); pnIndex ++) {
			boardList.add(boardAllList.get(pnIndex));
			
			userId.add(boardAllList.get(pnIndex).getuserid());
		}

		resultBoard.put("pnSize", pnSize);	
		resultBoard.put("boardList", boardList);
		resultBoard.put("members", getMembers(userId));
		
		return resultBoard;
	}

	@Override
	public void boardWrite(Object [] parameters) {
		
		String query = "insert into whereboard(connum, id, title, content, region)"
				+ "			values(whereboarder_seq.nextval, ?, ?, ?, ?)";
		
		jdbcTemplate.update(query, parameters);
		
	}

	@Override
	public BoardVO boardView(int boardId) {
		
		String query = "select * from whereboard where connum = ?";
		return jdbcTemplate.queryForObject(query, new BoardVOMapper(),  boardId);
	}

	@Override
	public void replyWrite(Object[] replyParameter) {
		
		String query = "insert into commenttbl(num, id, connum, nickname, title, content)"
				+ "values (?, ?, whereboarder_seq.nextval, ?, ?, ?)";
		
		jdbcTemplate.update(query, replyParameter);
	}
	
	@Override
	public ArrayList<String> getMembers(ArrayList<String> userId) {
		
		String query = "select nickname from membertbl where id = ?";		// 닉네임 조회
		ArrayList <String> members = new ArrayList<String>();
		
		for(String searchId : userId) {
	
		    String result = jdbcTemplate.queryForObject(query, new Object[]{searchId}, String.class);
		    members.add(result);
		}
		
		return members;
	}
	
	@Override
	public List<CommentVO> commentSearch(int commentId) {
		
		String query = "select * from commenttbl where num = ?";
		return jdbcTemplate.query(query, new CommentVOMapper(), commentId);	
	}
	
	private class CommentVOMapper implements RowMapper<CommentVO> {

		@Override
		public CommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CommentVO commentVO = new CommentVO();
			
			commentVO.setnum(rs.getInt("num"));
			commentVO.setid(rs.getString("id"));
			commentVO.setnum(rs.getInt("connum"));
			commentVO.setnickname(rs.getString("nickname"));
			commentVO.settitle(rs.getString("title"));
			commentVO.setcontent(rs.getString("content"));
			commentVO.setrecorddate(rs.getDate("bdate"));
			
			return commentVO;
		}
		
	}
	
	@Override
	public void boardDelete(String bId) {
		
		String query = "delete from whereboard where connum = ?";
		jdbcTemplate.update(query, bId);
	}
	
	@Override
	public void upHit(int boardId) {
		
		String query = "update whereboard set HIT = HIT+1 where connum = ?";
		
		jdbcTemplate.update(query, boardId);
	}
	
	@Override
	public void boardModify(Object [] boardEdit) {
		
		String query = "update whereboard set title = ?, content = ?, region =? where connum = ?";
		jdbcTemplate.update(query, boardEdit);
	}
	
	private class BoardVOMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setcontentnum(rs.getInt("connum"));
			boardVO.setuserid(rs.getString("id"));
			boardVO.settitle(rs.getString("title"));
			boardVO.setbcontent(rs.getString("content"));
			boardVO.setregion(rs.getString("region"));
			boardVO.sethit(rs.getInt("hit"));
			boardVO.setbdate(rs.getDate("bdate"));
			
			return boardVO;
		}
	}

}