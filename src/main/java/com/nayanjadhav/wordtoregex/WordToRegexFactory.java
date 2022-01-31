package com.nayanjadhav.wordtoregex;


/**
 * 
 * @author Nayan
 * 
 * Factory class to get default regex
 * 
 * */
public class WordToRegexFactory {
	private static RegexBuilder visaCreditCardRegex = new RegexBuilder();
	private static RegexBuilder indianAadhaarCardRegex = new RegexBuilder();
	private static RegexBuilder indianAadhaarCardWithSpaceRegex = new RegexBuilder();
	private static RegexBuilder indianPanCardRegex = new RegexBuilder();
	private static RegexBuilder americanSocialSecurityNumberRegex = new RegexBuilder();
	private static RegexBuilder emailRegex = new RegexBuilder();

	static {
		initDefault();
	}

	private static void initDefault() {

		visaCreditCardRegex.startOfLine().singleCharacter("4").digitsBetween(0, 9).numberOfPreceedingTokens(12)
				.startGroup().lookAheadWithPreviousString().digitsBetween(0, 9).numberOfPreceedingTokens(3).endGroup();

		indianAadhaarCardRegex.startOfLine().digitsBetween(2, 9).numberOfPreceedingTokens(1).digitsBetween(0, 9)
				.numberOfPreceedingTokens(3).digitsBetween(0, 9).numberOfPreceedingTokens(4)
				.digitsBetween(0, 9).numberOfPreceedingTokens(4);
		

		indianAadhaarCardWithSpaceRegex.startOfLine().digitsBetween(2, 9).numberOfPreceedingTokens(1).digitsBetween(0, 9)
				.numberOfPreceedingTokens(3).whiteSpace().digitsBetween(0, 9).numberOfPreceedingTokens(4).whiteSpace()
				.digitsBetween(0, 9).numberOfPreceedingTokens(4);

		indianPanCardRegex.startOfLine().lettersBetween('A', 'Z').numberOfPreceedingTokens(5).digitsBetween(0, 9)
				.numberOfPreceedingTokens(4).lettersBetween('A', 'Z').numberOfPreceedingTokens(1);

		americanSocialSecurityNumberRegex.startOfLine().startGroup().negativeLookAhead()
				.valuesWithOR("666", "000", "900-999").endGroup()
				.digitsBetween(0, 9)
				.numberOfPreceedingTokens(3)
				.singleCharacter("-").startGroup().negativeLookAhead()
				.valuesRange("00").endGroup()
				.digitsBetween(0, 9)
				.numberOfPreceedingTokens(2).singleCharacter("-").startGroup().negativeLookAhead()
				.valuesRange("0")
				.endGroup()
				.digitsBetween(0, 9)
				.numberOfPreceedingTokens(4);

		emailRegex.startOfLine().wordRegex().and().singleCharacter("@").smallCaseAndCapitalCaseLettersFromAToZ().and()
				.singleCharacter("\\.").smallCaseAndCapitalCaseLettersFromAToZ().numberOfPreceedingTokensRange(2,3);

		
	}

	public static String getVisaCreditCardRegex() {
		return visaCreditCardRegex.build();
	}

	public static String getIndianAadhaarCardRegex() {
		return indianAadhaarCardRegex.build();
	}
	
	public static String getIndianAadhaarCardWithSpaceRegex() {
		return indianAadhaarCardWithSpaceRegex.build();
	}

	public static String getIndianPanCardRegex() {
		return indianPanCardRegex.build();
	}

	public static String getAmericaSocialSecurityNumberRegex() {
		return americanSocialSecurityNumberRegex.build();
	}

	public static String getEmailRegex() {
		return emailRegex.build();
	}

	public static  String getPasswordRegex(int startLength, int endLength) {
		
		RegexBuilder regexBuilder = new RegexBuilder().startGroup().digitExistsAhead().endGroup().startGroup().smallCaseLetterExistsAhead().endGroup()
		.startGroup().capitalCaseLetterExistsAhead().endGroup();
		regexBuilder.numberOfPreceedingTokensRange(startLength, endLength);
		return regexBuilder.build();
	}

	public static String getDateYYYYMMDDRegex(Character separator) {

		RegexBuilder regexBuilder = new RegexBuilder().numberOfDigits(4).singleCharacter(separator.toString())
				.eitherNumberOfDigits(1, 2).singleCharacter(separator.toString()).eitherNumberOfDigits(1, 2);
		return regexBuilder.build();
	}

	public static String getDateDDMMYYYRegex(Character separator) {

		RegexBuilder regexBuilder = new RegexBuilder().eitherNumberOfDigits(1, 2).singleCharacter(separator.toString())
				.eitherNumberOfDigits(1, 2).singleCharacter(separator.toString()).numberOfDigits(4);
		return regexBuilder.build();
	}

	public static String getDateMMDDYYYYRegex(Character separator) {
		RegexBuilder regexBuilder = new RegexBuilder().eitherNumberOfDigits(1, 2).singleCharacter(separator.toString())
				.eitherNumberOfDigits(1, 2).singleCharacter(separator.toString()).numberOfDigits(4);
		return regexBuilder.build();
	}

}
