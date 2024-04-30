package com.wherehouse.recommand.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wherehouse.recommand.dao.IRecServiceEmpRepository;
import com.wherehouse.recommand.model.RecServiceVO;

@Service
public class RecServiceMonthlyService implements IRecService{

	@Autowired
	IRecServiceEmpRepository RecServiceEmpRepository;
	
	@Override
	public List<RecServiceVO> execute(Map<String, String> requestAjax) {
		
		List<RecServiceVO> RecServiceResult = RecServiceEmpRepository.chooseMonthlyRec(Integer.parseInt(requestAjax.get("deposit_avg")), Integer.parseInt(requestAjax.get("monthly_avg")),  Integer.parseInt(requestAjax.get("safe_score")), Integer.parseInt(requestAjax.get("cvt_score")));
		return RecServiceResult;
	}
}