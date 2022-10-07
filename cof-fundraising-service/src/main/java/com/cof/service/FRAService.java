package com.cof.service;

import java.util.List;

import com.cof.entity.FundRaisingActivity;

public interface FRAService {
	
	FundRaisingActivity createFRA(FundRaisingActivity fundRaisingActivity);
	FundRaisingActivity updateFRAInfo(FundRaisingActivity fundRaisingActivity, int id);
	List<FundRaisingActivity> getAllFundRaisingActivities();
	FundRaisingActivity getFundRaisingActivityById(int id);
	void deleteFundRaisingActivityById(int id);
	FundRaisingActivity getFundRaisingActivityByName(String name);

}
