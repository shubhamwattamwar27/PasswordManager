package com.example.passwordManagerMain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;




@Component
public class PasswprdGenerator {

	/*public static void main(String[] args) {
		PasswprdGenerator pwg = new PasswprdGenerator();
		String abc = pwg.generatePassword(15);
		BCrypt.hashpw(abc, BCrypt.gensalt());
		String aaa= BCrypt.hashpw(pwg.generatePassword(15), BCrypt.gensalt());
		System.err.println(aaa);
		System.err.println(abc);
		
	}*/
	
	public String generatePassword(int length) {
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      List<String> lettersAndSymb = new ArrayList<>();
	      lettersAndSymb.add(capitalCaseLetters);
	      lettersAndSymb.add(lowerCaseLetters);
	      lettersAndSymb.add(specialCharacters);
	      lettersAndSymb.add(numbers);
	      StringBuilder password = new StringBuilder();
	      //char[] password = new char[length];
	       
	      Random random = new Random();
	    
	      for(int i = 0; i< length ; i++) {
	          int ind = random.nextInt(lettersAndSymb.size());
	        	  password.append((lettersAndSymb.get(ind)).charAt
	        	  (random.nextInt((lettersAndSymb.get(ind)).length())));
	       }
	      return password.toString();
	   }
}
