package com.cof.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DONATION_TBL")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "amount")
	private double amount;
	@Column(name = "donor_name")
	private int donorName;
	@Column(name = "beneficiary_id")
	private int beneficiaryId;
	@Column(name = "is_visible_to_beneficiary")
	private boolean isVisibleToBeneficiary;
	@Column(name = "fundraising_activity_id")
	private int fundRaisingActivityId;

}
