package com.faye.flightSchedule.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate dateOfBirth;
	private String email;
	private String etaAccount;
	private String etaPwd;
	
	private String wxAccount;
}
