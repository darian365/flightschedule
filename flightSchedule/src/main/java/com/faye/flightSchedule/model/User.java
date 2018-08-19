package com.faye.flightSchedule.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String middleName;
	@Column
	private LocalDate dateOfBirth;
	@Column
	private String email;
	@Column
	private String etaAccount;
	@Column
	private String etaPwd;
	@Column
	private String wxAccount;

	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtaAccount() {
		return etaAccount;
	}

	public void setEtaAccount(String etaAccount) {
		this.etaAccount = etaAccount;
	}

	public String getEtaPwd() {
		return etaPwd;
	}

	public void setEtaPwd(String etaPwd) {
		this.etaPwd = etaPwd;
	}

	public String getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}
}
