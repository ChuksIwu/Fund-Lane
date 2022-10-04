package com.cof.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cof.dto.GroupCreationRequest;
import com.cof.entity.Group;
import com.cof.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupRepository repository;
	
	@Autowired
	private UserGroupService userGroupService;
				
	@Transactional(propagation= Propagation.REQUIRED)
	public String createGroup(GroupCreationRequest gcr) {
		
		Group group = new Group();		
		group.setGroupName(gcr.getGroupName());
		group.setDescription(gcr.getDescription());
		group.setGroupOwner(gcr.getGroupOwner());
		group.setGroupCoOwner(gcr.getGroupCoOwner());
		group.setJoinCode(RandomStringUtils.randomAlphanumeric(8));
		
		group = repository.save(group);
		
		int userId = group.getGroupOwner();
		int groupId = group.getId();
		int groupOwner = group.getGroupOwner();
		System.out.println(userId +" "+groupId+" "+groupOwner);
		userGroupService.saveUserGroup(userId, groupId);
		
		return "Group created successfully ";
	}
	
	@Transactional(propagation= Propagation.REQUIRED)
	public String joinGroupWithCode(String joinCode, int userId) {
		  
		  int groupId = getGroupByJoinCode(joinCode).getId();

		  userGroupService.saveUserToGroupWithCode(userId, groupId); 
		  return "Success";
	  
	  }
	 

	public String updateGroupInfo(Group group, int id) {
		
		Group groupFromDb = repository.findById(id).get();
		groupFromDb.setGroupName(group.getGroupName());
		groupFromDb.setDescription(group.getDescription());
		groupFromDb.setGroupOwner(group.getGroupOwner());
		groupFromDb.setGroupCoOwner(group.getGroupCoOwner());
		
		repository.saveAndFlush(groupFromDb);
		
		return "Group Info updated successfully";
	}

	public List<Group> getAllGroups() {
		
		return repository.findAll();
	}

	public Group getGroupById(int id) {
		
		return repository.findById(id).get();
	}

	public void deleteGroupById(int id) {
		
		repository.deleteById(id);		
	}

	@Override
	public List<Group> getUserGroups(int userId) {
		
		
		return repository.getUserGroups(userId);
	}
	
	public Group getGroupByJoinCode(String joinCode) {
		
		return repository.findByJoinCode(joinCode);
	}

}
