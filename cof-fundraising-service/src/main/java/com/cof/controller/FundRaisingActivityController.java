package com.cof.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cof.entity.Beneficiary;
import com.cof.entity.FundRaisingActivity;
import com.cof.service.BeneficiaryService;
import com.cof.service.FRAService;

@RestController
@RequestMapping("/api/activity")
public class FundRaisingActivityController {
	
	@Autowired
	private FRAService service;
	
	@Autowired
	private BeneficiaryService bService;
	
	
	@PostMapping("/create")
	public ResponseEntity<FundRaisingActivity> createPublicFRA(@RequestBody FundRaisingActivity fundRaisingActivity) {
		
		return new ResponseEntity<>(service.createFRA(fundRaisingActivity), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<FundRaisingActivity> updatePublicFRAInfo(@RequestBody FundRaisingActivity publicFundRaisingActivity, @PathVariable int id) {
		
		
		return new ResponseEntity<>(service.updateFRAInfo(publicFundRaisingActivity, id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<FundRaisingActivity> getAllPublicFundRaisingActivities(){
		
		return service.getAllFundRaisingActivities();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<FundRaisingActivity> getPublicFundRaisingActivityById(@PathVariable int id) {
		
		return ResponseEntity.ok(service.getFundRaisingActivityById(id));
	}
	
	@GetMapping("/get/{name}")
	public ResponseEntity<FundRaisingActivity> getFundRaisingActivityByName(@PathVariable String name){
		
		return ResponseEntity.ok(service.getFundRaisingActivityByName(name));
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteFundRaisingActivityById(int id) {
		service.deleteFundRaisingActivityById(id);
	}
	
	@PostMapping("/beneficiary/create")
	public ResponseEntity<Beneficiary> createBeneficiary(@RequestBody Beneficiary beneficiary) {
		
		return new ResponseEntity<>(bService.createBeneficiary(beneficiary), HttpStatus.CREATED);
	}
	
	@PutMapping("/beneficiary/update/{id}")
	public ResponseEntity<Beneficiary> updateBeneficiaryInfo(@RequestBody Beneficiary beneficiary, @PathVariable int id) {
		
		
		return new ResponseEntity<>(bService.updateBeneficiaryInfo(beneficiary, id), HttpStatus.OK);
	}

}
