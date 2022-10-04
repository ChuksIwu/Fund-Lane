package com.cof.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {

	private int id;
	private String password;
	private String firstName;
	@NotNull(message="Last name cannot be null.")
	private String lastName;
	@NotNull(message="You must provide a valid phone number.")
	private String phoneNumber;
	@NaturalId
	private String email;
}
