package com.example.passwordManagerMain.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.passwordManagerMain.service.PasswordManagerService;
import com.example.passwordManagerMain.util.PasswordDetails;


@Controller
@RequestMapping("/passwordManager")
public class PasswordManagerController {

	@Autowired
	private PasswordManagerService passwordManagerService; 
	public PasswordManagerController()
	{
		System.out.println("in index PasswordManagerController");
	}
	
	@GetMapping("/")
	public String showWelcomePage(Model map) {
		System.out.println("in show showWelcomePage page");
		map.addAttribute("details", passwordManagerService.getPasswordAllDetails());
		return "welcome"; // forward view : default
	}
	
	@GetMapping("/createPage")
	public String showCreatePage(Model map,HttpServletRequest request) {
		System.out.println("in show Create Page form");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		PasswordDetails passwordDetails;
		if(flashMap!=null) {
			Long id =(flashMap.get("id")!=null ? (Long) flashMap.get("id") : 0);
			String name =(flashMap.get("name")!=null ? (String) flashMap.get("name") : "");
			String password =(flashMap.get("password")!=null ? (String) flashMap.get("password") : "");
			passwordDetails = new PasswordDetails(id,name, password);
		}
		else
			passwordDetails = new PasswordDetails();
		map.addAttribute("createDetails",passwordDetails);
		return "createDetails"; // forward view : default
	}
	
	
	
	@GetMapping("/getSpecificCompany/{id}")
	public String getSpecificCompany(@PathVariable long id,Model map,RedirectAttributes flashMap) {
		System.out.println("in show getSpecificCompany form");
		PasswordDetails passwordDetails = passwordManagerService.findById(id).get();
		map.addAttribute("createDetails",passwordDetails);
		flashMap.addFlashAttribute("id",passwordDetails.getId());
		flashMap.addFlashAttribute("name",passwordDetails.getWebSiteName());
		flashMap.addFlashAttribute("password",passwordDetails.getPassword());
		return "redirect:/passwordManager/createPage"; // redirect view : default
	}
	
	@GetMapping("/deleteSpecificDetailsById/{id}")
	public String deleteSpecificDetailsById(@PathVariable long id) {
		System.out.println("in deleteSpecificDetailsById form");
		passwordManagerService.deleteById(id);
		return "redirect:/passwordManager/"; // redirect view : default
	}
	
	@RequestMapping(value="/generatePassword")
	public String generatePassword() {
		System.out.println("in generatePassword form");
		
		return passwordManagerService.generatePassword(); // forward view : default
	}
	
	@PostMapping("/saveAction")
	public String saveOrUpdatePasswordDetails(@ModelAttribute PasswordDetails createDetails) {
			passwordManagerService.saveDetails(createDetails);
		return "redirect:/passwordManager/";
	}
}
