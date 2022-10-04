package com.cof.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "FUNDRAISING_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundRaisingActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "fundraiser_name")
	private String fundraiserName;
	@Column(name = "description")
	private String description;
	@Column(name = "target_amount")
	private double targetAmount;
	@Column(name = "withdrawal_date")
	private Date withdrawalDate;
	@Column(name = "targeted_event_date")
	private Date targetedEventDate;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "is_public")
	private boolean isPublic;
	@Column(name = "group_id")
	private int groupId;

}
