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

import com.cof.dto.GroupCreationRequest;
import com.cof.entity.Group;
import com.cof.service.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {

	@Autowired
	private GroupService service;
		
	@PostMapping("/group/create")
	public String createGroup(@RequestBody GroupCreationRequest gcr) {
		
		service.createGroup(gcr);
		return "Group created successfully";
	}
	
	/*
	 * @PostMapping("/join") public String joinGroupWithCode(@RequestBody String
	 * joinCode, int userId, int groupId, int groupOwner) {
	 * service.joinGroupWithCode(joinCode, userId, groupId, groupOwner); return
	 * "Success"; }
	 */

	@PutMapping("/update/{groupId}")
	public String updateGroup(@RequestBody Group group, @PathVariable int groupId) {
		
		service.updateGroupInfo(group, groupId);	
		return "Group info updated";
	}
	
	@GetMapping("/allgroups")
	public List<Group> getAllGroups() {
		
		return service.getAllGroups();
	}
	
	@GetMapping("{id}")
	public Group getGroupById(@PathVariable int id) {
		
		return service.getGroupById(id);
	}
	
	@GetMapping("/usergroups/{userId}")
	public List<Group> getUserGroups(@PathVariable int userId){
		
		return service.getUserGroups(userId);
	}
	
	@DeleteMapping("/deletegroup/{id}")
	public String deleteGroupById(@PathVariable int id) {
		
		service.deleteGroupById(id);		
		return "Group has been deleted";

	}
	
	@PostMapping("/joinwithcode/{joinCode}/{userId}")
    public String joinGroupWithCode(@PathVariable String joinCode, @PathVariable int userId) {
		
		return service.joinGroupWithCode(joinCode, userId);
	}

}
