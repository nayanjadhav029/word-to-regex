package com.nayanjadhav.wordtoregex.test;

import com.nayanjadhav.wordtoregex.DefaultWordToRegex;
import com.nayanjadhav.wordtoregex.WordToRegexFactory;

public class Demo {
	
	public static void main(String[] args) {
		
		
		dateTest();
	}

	static void emailDemo() {
		
		String emailRegex = WordToRegexFactory.getEmailRegex();
		System.out.println(emailRegex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(emailRegex, "abc@gmail.com"));
		
		System.out.println(defaultWordToRegex.exactMatch(emailRegex, "abc@gmail.com"));
		
		System.out.println(defaultWordToRegex.apply(emailRegex, "abc@gmail.com").get());
		
	}
	
	static void visaCreditCardDemo() {
		
		String regex = WordToRegexFactory.getIndianAadhaarCardRegex();
		System.out.println(regex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(regex, ""));
		
		System.out.println(defaultWordToRegex.exactMatch(regex, ""));
		
		System.out.println(defaultWordToRegex.apply(regex, "").get());
		
	}
	
	static void indianPanCardDemo() {
		
		String regex = WordToRegexFactory.getIndianPanCardRegex();
		System.out.println(regex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(regex, ""));
		
		System.out.println(defaultWordToRegex.exactMatch(regex, ""));
		
		System.out.println(defaultWordToRegex.apply(regex, "").get());
		
	}
	
	static void SSNDemo() {
		
		String regex = WordToRegexFactory.getAmericaSocialSecurityNumberRegex();
		System.out.println(regex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(regex, ""));
		
		System.out.println(defaultWordToRegex.exactMatch(regex, ""));
		
		System.out.println(defaultWordToRegex.apply(regex, "").get());
		
	}
	
	static void passwordTest() {
		String regex = WordToRegexFactory.getPasswordRegex(8, 15);
		System.out.println(regex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(regex, ""));
		
		System.out.println(defaultWordToRegex.exactMatch(regex, ""));
		
		System.out.println(defaultWordToRegex.apply(regex, "").get());
		
	}
	
	static void dateTest() {
		String regex = WordToRegexFactory.getDateDDMMYYYRegex('-');
		System.out.println(regex);
		DefaultWordToRegex defaultWordToRegex = new DefaultWordToRegex();
		System.out.println(defaultWordToRegex.exists(regex, ""));
		
		System.out.println(defaultWordToRegex.exactMatch(regex, ""));
		
		System.out.println(defaultWordToRegex.apply(regex, "").get());
		
	}


}
