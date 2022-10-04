package com.cof.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "GROUP_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "group_name")
	@NotNull(message="You must provide a group to register.")
	private String groupName;
	@Column(name = "description")
	private String description;
	@Column(name = "group_owner")
	@NotNull(message="Every group has at least one owner.")
	private int groupOwner;
	@Column(name = "group_co_owner")
	private int groupCoOwner;
	@Column(name = "join_code", unique = true)
	private String joinCode;
	
}
