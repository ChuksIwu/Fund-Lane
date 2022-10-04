package com.cof.entity;

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
@Table(name= "BENEFICIARY_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "beneficiary")
	private int beneficiary;
	@Column(name = "account_number")
	private String beneficiaryAccountNumber;
	@Column(name = "bank")
	private String BeneficiaryBank;
	@Column(name = "fundraising_activity_id")
	private String fundRaisingActivityId;

}
