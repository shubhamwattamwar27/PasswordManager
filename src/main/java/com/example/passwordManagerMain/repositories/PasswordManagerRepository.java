package com.example.passwordManagerMain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.passwordManagerMain.util.PasswordDetails;

@Repository
public interface PasswordManagerRepository extends JpaRepository<PasswordDetails, Long>{

	PasswordDetails save(PasswordDetails p);
	
	List<PasswordDetails> findAll();
	
	Optional<PasswordDetails> findById(Long id);
	
	PasswordDetails getById(Long id);
	
	void deleteById(Long id);
	
	void deleteAll();
}
