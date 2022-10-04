package com.cof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cof.entity.FundRaisingActivity;
import com.cof.service.FRAService;

@RestController
@RequestMapping("/api/activity")
public class FundRaisingActivityController {
	
	@Autowired
	private FRAService service;
	
	@PostMapping("/create")
	public String createPublicFRA(@RequestBody FundRaisingActivity FundRaisingActivity) {
		
		service.createFRA(FundRaisingActivity);
		
		return "Fund raising created successfully";
	}
	
	@PutMapping("/update")
	public String updatePublicFRAInfo(@RequestBody FundRaisingActivity publicFundRaisingActivity, @PathVariable int id) {
		
		service.updateFRAInfo(publicFundRaisingActivity, id);
		return "Requested details have been updated";
	}
	@GetMapping("/all")
	public List<FundRaisingActivity> getAllPublicFundRaisingActivities(){
		
		return service.getAllFundRaisingActivities();
	}
	
	@GetMapping("/get/{id}")
	public FundRaisingActivity getPublicFundRaisingActivityById(int id) {
		
		return service.getFundRaisingActivityById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteFundRaisingActivityById(int id) {
		service.deleteFundRaisingActivityById(id);
	}

}
