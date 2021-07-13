package com.example.passwordManagerMain.controller;

import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.passwordManagerMain.service.PasswordManagerService;
import com.example.passwordManagerMain.util.CreateDetails;
import com.example.passwordManagerMain.util.PasswordDetails;


@Controller
@RequestMapping("/pm")
public class PasswordManagerController {

	@Autowired
	private PasswordManagerService passwordManagerService; 
	public PasswordManagerController()
	{
		System.out.println("in index PasswordManagerController");
	}
	
	@GetMapping("/")
	public String getIndexBySlash() {

		System.out.println("in index");
		
		return "index.html";
	}
	@GetMapping("/showWelcomePage")
	public String showWelcomePage(Model map) {
		System.out.println("in show login form");
		PasswordDetails pd =  (passwordManagerService.getPasswordAllDetails()).get(0);
		map.addAttribute("details", passwordManagerService.getPasswordAllDetails());
		return "welcome"; // forward view : default
	}
	
	@GetMapping("/createPage")
	public String showCreatePage(Model map,HttpServletRequest request) {
		System.out.println("in show Create Page form");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		CreateDetails createDetails;
		if(flashMap!=null) {
		Long id =(flashMap.get("id")!=null ? (Long) flashMap.get("id") : 0);
		String name =(flashMap.get("name")!=null ? (String) flashMap.get("name") : "");
		String password =(flashMap.get("password")!=null ? (String) flashMap.get("password") : "");
		createDetails = new CreateDetails(id,name, password);
		}
		else
			createDetails = new CreateDetails();
		map.addAttribute("createDetails",createDetails);
		return "createDetails"; // forward view : default
	}
	
	
	
	@GetMapping("/getSpecificCompany/{id}")
	public String getSpecificCompany(@PathVariable long id,Model map,RedirectAttributes flashMap) {
		System.out.println("in show login form");
		PasswordDetails pd = passwordManagerService.findById(id);
		map.addAttribute("createDetails",new CreateDetails(pd.getCompanyName(),pd.getPassword()));
		flashMap.addFlashAttribute("id",pd.getId());
		flashMap.addFlashAttribute("name",pd.getCompanyName());
		flashMap.addFlashAttribute("password",pd.getPassword());
		return "redirect:/pm/createPage"; // redirect view : default
	}
	
	@GetMapping("/deleteSpecificDetailsById/{id}")
	public String deleteSpecificDetailsById(@PathVariable long id) {
		System.out.println("in deleteSpecificDetailsById form");
		passwordManagerService.deleteById(id);
		return "redirect:/pm/showWelcomePage"; // redirect view : default
	}
	
	@RequestMapping(value="/generatePassword")
	public String generatePassword() {
		System.out.println("in generatePassword form");
		
		return passwordManagerService.generatePassword(); // forward view : default
	}
	
	@PostMapping("/saveAction")
	public String getAllPasswordDetails(@ModelAttribute CreateDetails createDetails) {
		if(createDetails.getId()!=null)
			passwordManagerService.saveDetails(new PasswordDetails(createDetails.getId(),createDetails.getWebSiteName(),createDetails.getPassword()));
		else
			passwordManagerService.saveDetails(new PasswordDetails(createDetails.getWebSiteName(),createDetails.getPassword()));
		return "redirect:/pm/showWelcomePage";
	}
}
