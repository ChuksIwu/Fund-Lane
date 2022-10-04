package com.cof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupRequest {
	
	int userId;
	int groupId;
	int groupOwner;

}
