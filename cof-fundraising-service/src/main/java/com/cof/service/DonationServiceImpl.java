package com.cof.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cof.entity.Donation;
import com.cof.repository.DonationRepository;

public class DonationServiceImpl implements DonationService {
	
	@Autowired
	private DonationRepository repository;

	@Override
	public Donation donate(Donation donation) {

		Donation d = new Donation();
		
		d.setPaymentStatus("Pending");
		//Make rest call to payment gateway. Return status
		return repository.save(d);
	}

}
