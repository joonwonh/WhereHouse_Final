package com.wherehouse.recommand.dao;


import java.util.List;

import com.wherehouse.recommand.model.*;

public interface IRecServiceEmpRepository {

	
	public List<RecServiceVO> chooseCharterRec(int inputData, int safe, int cvt);
	public List<RecServiceVO> chooseMonthlyRec(int deposit, int monthly, int safe, int cvt);
	
}
