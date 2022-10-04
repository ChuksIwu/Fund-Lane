package com.cof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cof.repository.UserGroupRepository;

@Service
public class UserGroupService {
	
	@Autowired
	private UserGroupRepository repository;
		
	public void saveUserGroup(int userId, int groupId) {
	
		repository.saveUserGroupOnCreation(userId, groupId);
	}
	
	public void saveUserToGroupWithCode(int userId, int groupId) {

		repository.saveUserGroupWithJoincode(userId, groupId);
	}
}
