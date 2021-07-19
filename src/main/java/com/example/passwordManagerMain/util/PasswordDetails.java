package com.example.passwordManagerMain.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;







@Entity
public class PasswordDetails implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String webSiteName;
	
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public PasswordDetails(long id, String webSiteName, String password) {
		super();
		this.id = id;
		this.webSiteName = webSiteName;
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getWebSiteName() {
		return webSiteName;
	}

	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PasswordDetails(String webSiteName, String password) {
		super();
		this.webSiteName = webSiteName;
		this.password = password;
	}

	public PasswordDetails() {
		super();
	}

	@Override
	public String toString() {
		return "PasswordDetails [webSiteName=" + webSiteName + ", password=" + password + "]";
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
