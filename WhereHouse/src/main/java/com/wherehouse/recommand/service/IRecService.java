package com.wherehouse.recommand.service;

import java.util.List;
import java.util.Map;

import com.wherehouse.recommand.model.RecServiceVO;

public interface IRecService {

	public List<RecServiceVO> execute(Map <String, String>requestAjax);
}
