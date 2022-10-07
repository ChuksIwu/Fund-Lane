package com.cof.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cof.entity.Beneficiary;
import com.cof.repository.BeneficiaryRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	private BeneficiaryRepository repository;

	@Override
	public Beneficiary createBeneficiary(Beneficiary beneficiary) {
		return repository.save(beneficiary);
			}

	@Override
	public Beneficiary updateBeneficiaryInfo(Beneficiary beneficiary, int id) {

		Beneficiary beneficiaryFromDb = repository.findById(id).get();
		beneficiaryFromDb.setBeneficiaryBank(beneficiary.getBeneficiaryBank());
		beneficiaryFromDb.setBeneficiaryAccountNumber(beneficiary.getBeneficiaryAccountNumber());
		return repository.saveAndFlush(beneficiaryFromDb);
		
	}
	
	public List<Beneficiary> getAllBeneficiaries() {
		
		return repository.findAll();
	}
	
	public Beneficiary getBeneficiaryById(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {

		repository.deleteById(id);
	}
	

}
