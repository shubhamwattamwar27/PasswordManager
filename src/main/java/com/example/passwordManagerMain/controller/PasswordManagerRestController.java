package com.example.passwordManagerMain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.passwordManagerMain.service.PasswordManagerService;
import com.example.passwordManagerMain.util.CreateDetails;
import com.example.passwordManagerMain.util.PasswordDetails;


@RestController
@RequestMapping("/rest")
public class PasswordManagerRestController {

	@Autowired
	private PasswordManagerService passwordManagerService; 
		
	@RequestMapping(value="/generatePassword")
	public String generatePassword() {
		System.out.println("in generatePassword form");
		
		return passwordManagerService.generatePassword(); // forward view : default
	}
	
}
