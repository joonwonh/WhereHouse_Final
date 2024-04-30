package com.wherehouse.recommand.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wherehouse.recommand.model.RecServiceVO;

@Repository
public class RecServiceEmpRepository implements IRecServiceEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<RecServiceVO> chooseCharterRec(int inputData, int safe, int cvt) {						
		
		List<RecServiceVO> recServiceResult;
		
		String query = "";
		
		if(safe>cvt)	{
			query = "SELECT * FROM(SELECT * FROM gu_info WHERE charter_avg <= ? ORDER BY safe_score DESC, charter_avg DESC) WHERE ROWNUM <= 3";
		}
		
		else if(safe<cvt)	{
			query = "SELECT * FROM(SELECT * FROM gu_info WHERE charter_avg <= ? ORDER BY cvt_score DESC, charter_avg DESC) WHERE ROWNUM <= 3";
		}
		
		else if(cvt == safe)	{
			query = "SELECT * FROM (SELECT * FROM gu_info WHERE charter_avg <= ?  ORDER BY CASE"
					+ "WHEN (?+1)*10 < 60"
					+ "	THEN charter_avg"
					+ "	ELSE cvt_score  END DESC,"
					+ "	charter_avg DESC)"
					+ "WHERE ROWNUM <= 3";
		}
		
		if(cvt != safe) {
			recServiceResult = jdbcTemplate.query(query, new Object[]{inputData}, new EmpMapper());
			System.out.println("RecServiceResult.size() : " + recServiceResult.size());
		} else {
			recServiceResult = jdbcTemplate.query(query, new Object[]{inputData, safe}, new EmpMapper());
			System.out.println("RecServiceResult.size() : " + recServiceResult.size());
		}
		
	        
		return recServiceResult;
	}

	@Override
	public List<RecServiceVO> chooseMonthlyRec(int deposit, int monthly, int safe, int cvt) {				
		
		List<RecServiceVO> RecServiceResult;
		String query = "";
		
		if(safe>cvt)	{
			query = "SELECT * FROM(SELECT * FROM gu_info WHERE monthly_avg <= ? AND deposit_avg <=? ORDER BY safe_score DESC, monthly_avg DESC) WHERE ROWNUM <= 3";
		}
		else if(safe<cvt)	{
			query = "SELECT * FROM(SELECT * FROM gu_info WHERE monthly_avg <= ? AND deposit_avg <=? ORDER BY cvt_score DESC, monthly_avg DESC) WHERE ROWNUM <= 3";
		}
		else if(cvt == safe)	{
			query = "SELECT * FROM(SELECT * FROM gu_info WHERE monthly_avg <= ? AND deposit_avg <=? ORDER BY CASE WHEN ?*10 < 50 THEN monthly_avg ELSE cvt_score END DESC, monthly_avg DESC) WHERE ROWNUM <= 3";
		}
		
		if(cvt != safe) {
			RecServiceResult = jdbcTemplate.query(query, new Object[]{monthly, deposit}, new EmpMapper());
		} else {
			RecServiceResult = jdbcTemplate.query(query, new Object[]{monthly, deposit, safe}, new EmpMapper());
		}
		
		return RecServiceResult;
	}
	
	private class EmpMapper implements RowMapper<RecServiceVO>{			

		@Override
		public RecServiceVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
			RecServiceVO dto = new RecServiceVO();
			dto.setGu_id(rs.getInt("gu_id"));
            dto.setGu_name(rs.getString("gu_name"));	
            dto.setCvt_score(rs.getInt("cvt_score"));
            dto.setSafe_score(rs.getInt("safe_score"));
            dto.setCafe(rs.getInt("cafe"));
            dto.setCvt_store(rs.getInt("cvt_store"));
            dto.setDaiso(rs.getInt("daiso"));
            dto.setOliveYoung(rs.getInt("oliveYoung"));
            dto.setRestourant(rs.getInt("restourant"));
            dto.setPolice_office(rs.getInt("police_office"));
            dto.setCctv(rs.getInt("cctv"));
            dto.setCharter_avg(rs.getInt("charter_avg"));
            dto.setDeposit_avg(rs.getInt("deposit_avg"));
            dto.setMonthly_avg(rs.getInt("monthly_avg"));
            
			return dto;
		}
	}
}
