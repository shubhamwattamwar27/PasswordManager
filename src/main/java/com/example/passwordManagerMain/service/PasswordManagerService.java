package com.example.passwordManagerMain.service;

import java.util.List;

import com.example.passwordManagerMain.util.PasswordDetails;



public interface PasswordManagerService {

	List<PasswordDetails> getPasswordAllDetails();
	
	String generatePassword();
	
	PasswordDetails saveDetails(PasswordDetails passwordDetails);
	
	PasswordDetails findById(Long id);
	
	void deleteById(Long id);
}

