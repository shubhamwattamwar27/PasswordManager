package com.example.passwordManagerMain.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PasswordDetails {

	private long id;
	private String companyName;
	
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public PasswordDetails(long id, String companyName, String password) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PasswordDetails(String companyName, String password) {
		super();
		this.companyName = companyName;
		this.password = password;
	}

	public PasswordDetails() {
		super();
	}

	@Override
	public String toString() {
		return "PasswordDetails [companyName=" + companyName + ", password=" + password + "]";
	}
	
	
	//CREATE SCHEMA `projectmanager` ;
/*	CREATE TABLE `projectmanager`.`passworddetails` (
			  `id` INT NULL,
			  `company_name` VARCHAR(45) NULL,
			  `password` VARCHAR(45) NOT NULL,
			  PRIMARY KEY (`id`, `password`));
*/
	
	
	//CREATE SCHEMA `passwordmanager` ;

	
}
