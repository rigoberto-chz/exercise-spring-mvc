package com.example.spring.mvc.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMasking {

	public static String maskEmail(String email) {
		Pattern pattern = Pattern.compile("(^[^@]{1})([^@]*)([^@]{1})(@.*$)");
		Matcher matcher = pattern.matcher(email);

		if (matcher.find()) {
			String firstChar = matcher.group(1);
			String lastChar = matcher.group(3);
			String domain = matcher.group(4);
			return firstChar.concat(String.valueOf("X".repeat(matcher.group(2).length()))).concat(lastChar).concat(domain);
		} else {
			return email;
		}
	}
	
}
