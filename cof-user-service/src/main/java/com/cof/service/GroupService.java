package com.cof.service;

import java.util.List;

import com.cof.dto.GroupCreationRequest;
import com.cof.entity.Group;

public interface GroupService {
	
	String createGroup(GroupCreationRequest gcr);
	String updateGroupInfo(Group group, int id);
	List<Group> getAllGroups();
	Group getGroupById(int id);
	List<Group> getUserGroups(int userId);
	void deleteGroupById(int id);
	
	String joinGroupWithCode(String joinCode, int userId);
	 	
	Group getGroupByJoinCode(String joinCode);	
}
	