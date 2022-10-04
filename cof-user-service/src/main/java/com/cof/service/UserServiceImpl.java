package com.cof.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cof.dto.FundRaiserRequest;
import com.cof.dto.UserCreationDTO;
import com.cof.entity.User;
import com.cof.exception.UserNotFound;
import com.cof.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserGroupService ugService;
	
	WebClient webClient;
	
	private static final String FRAUrl = "http://localhost:8082/api/activity";

	
	public String registerUser(UserCreationDTO userCreationDTO) {
		
		User user = new User();
		user.setFirstName(userCreationDTO.getFirstName());
		user.setLastName(userCreationDTO.getLastName());
		user.setPassword(userCreationDTO.getPassword());
		user.setEmail(userCreationDTO.getEmail());
		user.setPhoneNumber(userCreationDTO.getPhoneNumber());
		
		repository.save(user);
		
		return "User created successfully";
	}

	public String updateUser(User user, int id) {
		
		User userFromDb = repository.findById(id)
				.orElseThrow(()-> new UserNotFound("We are having problems retrieving the details to update. Please try again later."));
		userFromDb.setFirstName(user.getFirstName());
		userFromDb.setLastName(user.getLastName());
		userFromDb.setEmail(user.getEmail());
		userFromDb.setPhoneNumber(user.getPhoneNumber());
		repository.saveAndFlush(userFromDb);
		
		return "User info updated";
	}

	public List<User> getAllUsers() {
		
		return repository.findAll();
	}
	
	public User getUserById(int id) throws UserNotFound{
		
		User user = repository.findById(id).orElseThrow(() -> new UserNotFound("This user does not exist in our system"));
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		
		repository.findById(id).orElseThrow(() -> new UserNotFound("This user appears not to be in our system"));
		
		repository.deleteById(id);
	}

	public User login(String email, String password) {
		// After logging in, get user group info
		return repository.login(email, password);
	}

	public UserServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(FRAUrl).build();
	}
	
	@Override
	@CircuitBreaker(name="fundraisers", fallbackMethod= "fundRaiserRetrievalFallback")
	public Mono<String> createFundraiser(FundRaiserRequest frr) {
		
		return webClient.post().uri("/create").syncBody(frr).retrieve().bodyToMono(String.class);
	}  
	
	public Mono<String> fundRaiserRetrievalFallback(Exception e){
		
		return Mono.just("This service is not available. Please try later");
	}
	
	public Flux<FundRaiserRequest> getAllFundraisers(){
		
		return webClient.get().uri("/all").retrieve().bodyToFlux(FundRaiserRequest.class);
	}
	
}
