package com.cof.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER_GROUP_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserGroupId.class)
public class UserGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	int userId;
	@Id
	int groupId;

}
