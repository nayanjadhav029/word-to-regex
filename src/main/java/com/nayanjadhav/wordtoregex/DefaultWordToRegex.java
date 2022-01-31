package com.nayanjadhav.wordtoregex;

import java.util.Optional;


/**
 * 
 * @author Nayan
 * 
 * Default implementation for word to regex conversion
 * 
 * */
public class DefaultWordToRegex implements WordToRegex {

	@Override
	public Optional<String> apply(String regex, String inputString) {
		
		validate(regex, inputString);
		return apply(regex, inputString);
	}

	@Override
	public boolean exists(String regex, String inputString) {
		validate(regex, inputString);
		return exists(regex, inputString);
	}

	@Override
	public boolean exactMatch(String regex, String inputString) {

		validate(regex, inputString);
		return exactMatch(regex, inputString);
	}

}
