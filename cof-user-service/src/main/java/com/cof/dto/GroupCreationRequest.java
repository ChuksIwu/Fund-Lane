package com.cof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreationRequest {
	
	private int id;
	private String groupName;
	private String description;
	private int groupOwner;
	private int groupCoOwner;
	private String joinCode;
}
