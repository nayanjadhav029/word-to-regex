package com.nayanjadhav.wordtoregex;


/**
 * @author Nayan
 * 
 * Builder class for regex
 * 
 * */
public class RegexBuilder {

	private StringBuffer regexString = new StringBuffer();

	
	/**
	 * Regex to find a single digit in input string
	 * 
	 * 
	 * */
	public RegexBuilder singleDigit() {
		this.regexString.append("\\d{1}");
		return this;
	}

	
	/**
	 * Regex to specify number of digits expected in the expression
	 * eg - \d{2} -- This will match 2 digit based expression
	 * 
	 * 
	 * */
	public RegexBuilder numberOfDigits(int number) {
		this.regexString.append("\\d{" + number + "}");
		return this;
	}

	/**
	 * Regex to match number of tokens/character/digits from immediate previous expression
	 * 
	 * 
	 * */
	public RegexBuilder numberOfPreceedingTokens(int number) {
		this.regexString.append("{" + number + "}");
		return this;
	}


	/**
	 * Regex to match number of tokens/character/digits from immediate previous expression with 
	 * given range
	 * 
	 * */
	public RegexBuilder numberOfPreceedingTokensRange(int start, int end) {
		this.regexString.append("{" + start + "," + end +"}");
		return this;
	}

	

	/**
	 * Regex to match white space
	 * 
	 * 
	 * */
	public RegexBuilder whiteSpace() {
		this.regexString.append("\\s");
		return this;
	}

	/**
	 *
	 * Regex to match either number of digits 
	 * eg - /d{1,2} -- will match 1, 01, 11, 12,13,14.. etc
	 * 
	 */
	public RegexBuilder eitherNumberOfDigits(int firstNumber, int secondNumber) {
		this.regexString.append("\\d{" + firstNumber + "," + secondNumber + "}");
		return this;
	}


	/**
	 * Regex to match digits between provided range
	 * eg - [1-4] -- will match 1, 2, 3, 4
	 * 
	 * */
	public RegexBuilder digitsBetween(int startDigit, int endDigit) {
		this.regexString.append("[" + startDigit + "-" + endDigit + "]");
		return this;
	}


	/**
	 * Regex to match letters between provided range
	 * eg - [a-d] -- will match a,b,c,d
	 * 
	 * */
	public RegexBuilder lettersBetween(Character startLetter, Character endLetter) {
		this.regexString.append("[" + startLetter + "-" + endLetter + "]");
		return this;
	}


	/**
	 * Regex to match any word
	 * 
	 * 
	 * */
	public RegexBuilder wordRegex() {
		this.regexString.append("\\w");
		return this;
	}


	/**
	 * Regex to match forward slash
	 * 
	 * */
	public RegexBuilder forwardSlash() {
		this.regexString.append("\\/");
		return this;
	}


	/**
	 * Regex to match backward slash
	 * 
	 * */
	public RegexBuilder backwardSlash() {
		this.regexString.append("\\");
		return this;
	}


	/**
	 * Regex to match proceeding string along with previous string
	 * eg - a(?:b) --will match ab from abc string
	 * 
	 * */
	public RegexBuilder lookAheadWithPreviousString() {
		this.regexString.append("?:");
		return this;
	}


	/**
	 * Regex to match single character
	 * 
	 * */
	public RegexBuilder singleCharacter(String character) {
		this.regexString.append(character);
		return this;
	}


	/**
	 * Regex to match start of group
	 * 
	 * */
	public RegexBuilder startGroup() {
		this.regexString.append("(");
		return this;
	}


	/**
	 * Regex to match end of group
	 * 
	 * */
	public RegexBuilder endGroup() {
		this.regexString.append(")");
		return this;
	}

	public RegexBuilder endOfLine() {
		this.regexString.append("$");
		return this;
	}

	public static String endOfLine_() {
		return "$";
	} 
	public RegexBuilder value1Orvalue2(String value1, String value2) {
		this.regexString.append("(" + value1 + "|" + value2 + ")");
		return this;
	}

	public RegexBuilder valuesWithOR(String... values) {

		this.regexString.append("(");
		for (String value : values) {
			this.regexString.append(value + "|");
		}
		regexString.deleteCharAt(regexString.length() - 1);
		this.regexString.append(")");
		return this;
	}

	public RegexBuilder valuesRange(String... values) {
		this.regexString.append("[");
		for (String value : values) {
			this.regexString.append(value);
		}
		this.regexString.append("]");
		return this;
	}

	public RegexBuilder valuesRangeNotIn(String... values) {
		this.regexString.append("[^");
		for (String value : values) {
			this.regexString.append(value);
		}
		this.regexString.append("]");
		return this;
	}

	public RegexBuilder any() {
		this.regexString.append(".*");
		return this;
	}

	public RegexBuilder and() {
		this.regexString.append("+");
		return this;
	}

	public RegexBuilder negativeLookAhead() {
		this.regexString.append("?!");
		return this;
	}

	public RegexBuilder digitExistsAhead() {
		this.regexString.append("(?=.*\\d)");
		return this;
	}

	public RegexBuilder digitNotExists() {
		this.regexString.append("(?!.*\\d)");
		return this;
	}

	public RegexBuilder smallCaseLetterExistsAhead() {
		this.regexString.append("(?=.*[a-z])");
		return this;
	}

	public RegexBuilder smallCaseLetterNotExists() {
		this.regexString.append("(?!.*[a-z])");
		return this;
	}

	public RegexBuilder capitalCaseLetterExistsAhead() {
		this.regexString.append("(?=.*[A-Z])");
		return this;
	}

	public RegexBuilder capitalCaseLetterNotExists() {
		this.regexString.append("(?!.*[A-Z])");
		return this;
	}

	public RegexBuilder smallCaseAndCapitalCaseLettersFromAToZ() {
		this.regexString.append("[a-zA-Z]");
		return this;
	}

	public RegexBuilder startOfLine() {
		this.regexString.append("^");
		return this;
	}

	public RegexBuilder startOfString() {
		this.regexString.append("\\A");
		return this;
	}

	public String build() {
		return "(" + regexString.toString() + ")";
	}

	@Override
	public String toString() {
		return "RegexBuilder [regexString=" + regexString + "]";
	}
	
	

}
