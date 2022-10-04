package com.cof.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RequestBody;

import com.cof.dto.FundRaiserRequest;
import com.cof.dto.UserCreationDTO;
import com.cof.entity.User;
import com.cof.exception.UserNotFound;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	
	String registerUser(UserCreationDTO userCreationDTO);
	
	String updateUser(User user, int id);
	
	List<User> getAllUsers();
	
	User getUserById(int id) throws  UserNotFound;
	
	void deleteUserById(int id);
		
	User login(String email, String passowrd);	
	
	Flux<FundRaiserRequest> getAllFundraisers();
	
	Mono<String> createFundraiser(@RequestBody FundRaiserRequest frr);
}
