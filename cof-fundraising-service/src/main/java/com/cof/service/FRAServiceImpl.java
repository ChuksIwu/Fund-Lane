package com.cof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cof.entity.FundRaisingActivity;
import com.cof.repository.FundRaisingActivityRepository;

@Service
public class FRAServiceImpl implements FRAService {
	
	@Autowired
	FundRaisingActivityRepository repository;
	

	@Override
	public FundRaisingActivity createFRA(FundRaisingActivity fundRaisingActivity) {
		
		fundRaisingActivity.setActive(false);

		return repository.save(fundRaisingActivity);
	}

	@Override
	public FundRaisingActivity updateFRAInfo(FundRaisingActivity publicFRA, int id) {


		FundRaisingActivity pfraFromDb = repository.findById(id).get();
		pfraFromDb.setTargetAmount(publicFRA.getTargetAmount());
		pfraFromDb.setTargetedEventDate(publicFRA.getTargetedEventDate());
		pfraFromDb.setWithdrawalDate(publicFRA.getWithdrawalDate());
		
		return repository.saveAndFlush(pfraFromDb);
		
	}

	@Override
	public List<FundRaisingActivity> getAllFundRaisingActivities() {

		return repository.findAll();
	}

	@Override
	public FundRaisingActivity getFundRaisingActivityById(int id) {

		return repository.findById(id).get();
	}

	@Override
	public void deleteFundRaisingActivityById(int id) {
		
		repository.deleteById(id);
		
	}
	
	public FundRaisingActivity getFundRaisingActivityByName(String name) {
		
		return repository.findFundRaisingActivityByfundraiserName(name);
	}

}
