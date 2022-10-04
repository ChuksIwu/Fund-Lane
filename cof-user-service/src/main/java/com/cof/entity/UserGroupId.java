package com.cof.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupId implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userId;
	private int groupId;

}
