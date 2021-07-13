package com.example.passwordManagerMain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.passwordManagerMain.hash.BCrypt;
import com.example.passwordManagerMain.repositories.PasswordManagerRepository;
import com.example.passwordManagerMain.util.PasswordDetails;
import com.example.passwordManagerMain.util.PasswprdGenerator;


@Service
public class PasswordManagerServiceImpl implements PasswordManagerService{

	@Autowired
	private PasswordManagerRepository pmd;
	@Override
	public List<PasswordDetails> getPasswordAllDetails() {
		// TODO Auto-generated method stub
		//pmd.save(entity);
		return pmd.findAll();
		
	}
	@Override
	public String generatePassword() {
		PasswprdGenerator pwg = new PasswprdGenerator();
		String password= BCrypt.hashpw(pwg.generatePassword(15), BCrypt.gensalt());
		return password;
	}
	@Override
	public PasswordDetails saveDetails(PasswordDetails passwordDetails) {
		
		return pmd.save(passwordDetails);
	}
	@Override
	public PasswordDetails findById(Long id) {
		
		return pmd.getById(id);
	}
	@Override
	public void deleteById(Long id) {
		pmd.deleteById(id);
		
	}

	
}
