package com.wherehouse.members.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.wherehouse.members.model.MembersVO;

@Repository
public class MembersRepository implements IMembersRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public Map<String, Object> checkMember(String id, String pw) {
		
		String query = "select * from membertbl where id = ?";
		HashMap<String, Object> resObj = new HashMap<String, Object>(); 
		
		MembersVO membersVO = null;
		
		try {
			membersVO = jdbcTemplate.queryForObject(query, new MemberVOMapper(), new Object[] {id});	
		}catch(EmptyResultDataAccessException e) {	
			
//			System.out.println("MembersRepository.checkMember : -1 반환");
			
			resObj.put("resInt", "-1");
			return resObj;
		}
		
		if(membersVO.getPw().equals(pw)) {
//			System.out.println("MembersRepository.checkMember : 0 반환");
			resObj.put("membersVO", membersVO);
			resObj.put("resInt", "1");
			return resObj;
		}else {
//			System.out.println("MembersRepository.checkMember : 1 반환");
			resObj.put("resInt", "0");
			return resObj;
		}
	}

	@Override
	public int confimMember(String id) {
		
		String query = "select * from membertbl where id = ?";
		
		if(jdbcTemplate.queryForList(query, id).size() >= 1){
			
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int addMember(Map <String, String> requestData) {
		
		String query = "insert into membertbl (id, pw, nickname, tel, email) values (?,?,?,?,?)";
		jdbcTemplate.update(query,  new Object[] { requestData.get("id"), requestData.get("pw"), requestData.get("nickName"), requestData.get("tel"), requestData.get("email")});
		
		return 0;
	}
	
	@Override
	public MembersVO getMember(String parameterId) {
		
		String query = "select * from membertbl where id = ?";
//		System.out.println("parameterId : " + parameterId);
		
		return jdbcTemplate.queryForObject(query, new MemberVOMapper(), parameterId);
	}
	
	@Override
	public int editMember(Object[] editParameter) {
		
		String nickquery = "select * from membertbl where nickname = ? and  id !=?";
		String query = "update membertbl set pw=?, nickname=?, tel=?, email=? where id=?";
			
		if( jdbcTemplate.query(nickquery, new MemberVOMapper(), new Object[] {editParameter[1], editParameter[4]}).isEmpty()) {
//			System.out.println("닉네임 중복x");
			return jdbcTemplate.update(query, editParameter) ; 
	
		} else {
//			System.out.println("닉네임 중복");
			return 2;
		}
	}
	
	private class MemberVOMapper implements RowMapper<MembersVO> {

		@Override
		public MembersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			MembersVO membersVo = new MembersVO();
			
			membersVo.setId(rs.getString("id"));
			membersVo.setPw(rs.getString("pw"));
			membersVo.setNickName(rs.getString("nickname"));
			membersVo.setTel(rs.getString("tel"));
			membersVo.setEmail(rs.getString("email"));
			membersVo.setJoinDate(rs.getDate("joinDate"));
			
			return membersVo;
		}
	}

	
}
