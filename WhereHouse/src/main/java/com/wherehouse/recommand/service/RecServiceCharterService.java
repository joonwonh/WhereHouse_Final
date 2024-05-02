package com.wherehouse.recommand.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wherehouse.recommand.dao.IRecServiceEmpRepository;
import com.wherehouse.recommand.model.RecServiceVO;

@Service
public class RecServiceCharterService implements IRecService{

	@Autowired
	IRecServiceEmpRepository recServiceEmpRepository;
	
	@Override
	public List<RecServiceVO> execute(Map <String, String> requestAjax) {
		
		List<RecServiceVO> RecServiceResult = recServiceEmpRepository.chooseCharterRec(Integer.parseInt(requestAjax.get("charter_avg")), Integer.parseInt(requestAjax.get("safe_score")),  Integer.parseInt(requestAjax.get("cvt_score"))); 
//		System.out.println("RecServiceCharter in RecServiceResult.size : " + RecServiceResult.size());
		
		return RecServiceResult;
	}
}
