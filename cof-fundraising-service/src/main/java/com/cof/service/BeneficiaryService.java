package com.cof.service;

import java.util.List;

import com.cof.entity.Beneficiary;

public interface BeneficiaryService {
	
	Beneficiary createBeneficiary(Beneficiary beneficiary);

	Beneficiary updateBeneficiaryInfo(Beneficiary beneficiary, int id);
	
	List<Beneficiary> getAllBeneficiaries();
	Beneficiary getBeneficiaryById(int id);
	void deleteById(int id);
}
