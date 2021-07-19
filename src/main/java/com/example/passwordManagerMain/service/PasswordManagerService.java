package com.example.passwordManagerMain.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.example.passwordManagerMain.util.PasswordDetails;



public interface PasswordManagerService {

	List<PasswordDetails> getPasswordAllDetails();
	
	String generatePassword();
	
	PasswordDetails saveDetails(PasswordDetails passwordDetails);
	
	Optional<PasswordDetails> findById(Long id);
	
	void deleteById(Long id);
	
	void deleteAllById(List<Long> id);
	
	void deleteAll();
}

