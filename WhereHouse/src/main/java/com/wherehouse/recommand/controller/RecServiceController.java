package com.wherehouse.recommand.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wherehouse.recommand.model.RecServiceVO;
import com.wherehouse.recommand.service.IRecService;


@Controller
@RequestMapping(value="/RecServiceController")
public class RecServiceController {
	
	@Autowired
	@Qualifier("recServiceCharterService")
	IRecService recServiceCharterService;
	
	@Autowired
	@Qualifier("recServiceMonthlyService")
	IRecService recServiceMonthlyService;
	
	@RequestMapping(value="/charter", method=RequestMethod.POST)
	public @ResponseBody List<RecServiceVO> ControllerRecServiceCharter(@RequestBody Map<String, String>requestAjax) {
//		System.out.println("/charter 메소드 실행");
		
		if(requestAjax.get("charter_avg").equals("")) {
			return null;
		}
		else {
			List<RecServiceVO> RecServiceResult = recServiceCharterService.execute(requestAjax);	
			return RecServiceResult;
		}
	}
	
	@RequestMapping(value="/monthly", method=RequestMethod.POST)
	public @ResponseBody List<RecServiceVO> ControllerRecServiceMothly(@RequestBody Map<String, String>requestAjax) {	
//		System.out.println("/monthly 메소드 실행");
		
		if(requestAjax.get("deposit_avg").equals("")) {
			return null;
		} else {
			List<RecServiceVO> RecServiceResult = recServiceMonthlyService.execute(requestAjax);
			return RecServiceResult;
		}
	}
}