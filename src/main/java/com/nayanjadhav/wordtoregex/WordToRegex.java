package com.nayanjadhav.wordtoregex;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Nayan
 * 
 *         Interface for word to regex conversion
 * 
 */

public interface WordToRegex {

	default public Optional<String> apply(String regex, String inputString) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputString);

		return matcher.find() ? Optional.of(matcher.group()) : Optional.empty();
	}

	default public boolean exists(String regex, String inputString) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(inputString).find() ? true : false;
	}

	default public boolean exactMatch(String regex, String inputString) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(inputString).matches() ? true : false;
	}

	default public void validate(String regex, String inputString) {

		if (regex == null)
			throw new IllegalArgumentException("No value present in RegexBuilder");
		if (inputString == null)
			throw new IllegalArgumentException("No value present in inputString");

	}

}
