package com.cof.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cof.dto.FundRaiserRequest;
import com.cof.dto.GroupCreationRequest;
import com.cof.dto.UserCreationDTO;
import com.cof.entity.Group;
import com.cof.entity.User;
import com.cof.service.GroupService;
import com.cof.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final String USER_SERVICE = "user_service";

	@Autowired
	private UserService uService;
	
	@Autowired
	private GroupService gService;
	
		
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody @Valid UserCreationDTO userCreationDTO) {
		
		return new ResponseEntity<>(uService.registerUser(userCreationDTO), HttpStatus.CREATED);
			}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return ResponseEntity.ok(uService.getAllUsers());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		
		return ResponseEntity.ok(uService.getUserById(id));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id) {
		
		uService.deleteUserById(id);
		
		return "User has been succesfully deleted";
		
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable int id) {
		
		uService.updateUser(user, id);
		
		return new ResponseEntity<>(uService.updateUser(user, id), HttpStatus.OK);
	}
		
	@PostMapping("/group/create")
	public ResponseEntity<String> createGroup(@RequestBody @Valid GroupCreationRequest gcr) {
		
		return new ResponseEntity<>(gService.createGroup(gcr), HttpStatus.CREATED);
			
	}
	
	@PutMapping("/group/update/{groupId}")
	public ResponseEntity<String> updateGroupInfo(@RequestBody Group group, @PathVariable int groupId) {
				
		return new ResponseEntity<>(gService.updateGroupInfo(group, groupId), HttpStatus.OK);
	}
	
	@GetMapping("/group/all")
	public ResponseEntity<List<Group>> getAllGroups(){
		
		return ResponseEntity.ok(gService.getAllGroups());
	}
	
	@GetMapping("/group/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable int id){
		
		return ResponseEntity.ok(gService.getGroupById(id));
		
	}

	
	@GetMapping("/usergroups/{userId}")
	public ResponseEntity<List<Group>> getUserGroups(@PathVariable int userId){
		
		return ResponseEntity.ok(gService.getUserGroups(userId));
		
	}
	
	
	@DeleteMapping("/group/delete/{id}")
	public String deleteGroupById(@PathVariable int id) {
		
		gService.deleteGroupById(id);		
		return "Group has been deleted";
		
	}
	
	@PostMapping("/group/join/{joinCode}/{userId}")
	public ResponseEntity<String> joinGroupWithCode(@PathVariable String joinCode, @PathVariable int userId) {
		
		return new ResponseEntity<>(gService.joinGroupWithCode(joinCode, userId), HttpStatus.CREATED);
			
	}
	
	@GetMapping("/group/{joinCode}")
	public ResponseEntity<Group> getGroupByJoinCode(@PathVariable String joinCode){
		
		return ResponseEntity.ok(gService.getGroupByJoinCode(joinCode));
		
	}
	
	//@CircuitBreaker(name=USER_SERVICE, fallbackMethod="fundRaiserCreationFallback")
	@PostMapping("/fundraiser/create")
	public Mono<String> createFundraiser(@RequestBody FundRaiserRequest request){
		
		return uService.createFundraiser(request);
		
	}
	
	/*
	 * public ResponseEntity<String> fundRaiserCreationFallback(RuntimeException
	 * runException) {
	 * 
	 * return new
	 * ResponseEntity<String>("This service is down. Try again later",HttpStatus.OK)
	 * ; }
	 */
	@GetMapping("/fundraiser/all")
	public Flux<FundRaiserRequest> getAllFundraisers(){
	
		return uService.getAllFundraisers();
	
	}
	
	public Flux<FundRaiserRequest> fundRaiserRetrievalFallback(){
		return null;
	}
		
	
	@GetMapping("/getdonations/{userId}/{groupId}")
	public User contributionsByUser(@PathVariable int userId, int groupId){
		
		return null;	
	}
}
