package com.wherehouse.members.dao;

import java.util.Map;

import com.wherehouse.members.model.MembersVO;

public interface IMembersRepository {
	// 회원가입시
	public Map<String, Object> checkMember(String id, String pw);	
	public int confimMember(String id);											
	public int addMember(Map <String, String> requesetData);
	public MembersVO getMember(String parameterId);
	public int editMember(Object [] updateParameter);
}
