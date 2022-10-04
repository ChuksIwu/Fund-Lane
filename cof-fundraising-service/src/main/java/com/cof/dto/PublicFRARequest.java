package com.cof.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicFRARequest {
	
	private int id;
	private String name;
	private int groupId;
	private String description;
	private double targetAmount;
	private Date withdrawalDate;
	private Date targetedEventDate;
	private boolean isActive;


}
