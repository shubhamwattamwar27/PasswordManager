package com.example.passwordManagerMain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.passwordManagerMain.service.PasswordManagerService;
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
	
	@GetMapping("/")
	public List<PasswordDetails> showWelcomePage() {
		System.out.println("in show showWelcomePage page");
		
		return passwordManagerService.getPasswordAllDetails(); // forward view : default
	}
	
	@GetMapping("/getSpecificCompany/{id}")
	public PasswordDetails getSpecificCompany(@PathVariable long id) {
		System.out.println("in show getSpecificCompany form");
		PasswordDetails passwordDetails = passwordManagerService.findById(id);
		return passwordDetails; // redirect view : default
	}
	
	@PostMapping("/saveAction")
	public String savePasswordDetails(@ModelAttribute PasswordDetails createDetails) {
			passwordManagerService.saveDetails(createDetails);
		return "redirect:/pm/showWelcomePage";
	}
	
	@PatchMapping("/saveAction")
	public String updatePasswordDetails(@ModelAttribute PasswordDetails createDetails) {
			passwordManagerService.saveDetails(createDetails);
		return "redirect:/pm/showWelcomePage";
	}
}
