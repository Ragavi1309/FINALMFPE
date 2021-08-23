package com.cts.pointsmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	//employee id
	private int empid;
	
	//employee name
	private String userName;
	
	//authorized employee or not
	private boolean isValid;
}