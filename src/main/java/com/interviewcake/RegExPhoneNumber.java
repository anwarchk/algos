package com.interviewcake;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPhoneNumber {

	private static final Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
	private static final Pattern pattern1 = Pattern.compile("\\d{3}\\d{3}\\d{4}");
	private static final Pattern pattern2 = Pattern.compile("\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");


	public static void main(String[] args) {
		String str = "This is 1 test 123-456-7890";
		Matcher matcher = pattern2.matcher(str);
		if (matcher.find()) {
			System.out.println(matcher.group(0));
		}
		str = "This is 1 test 1234567890";
		matcher = pattern2.matcher(str);
		if (matcher.find()) {
			System.out.println(matcher.group(0));
		}
		
		str = "(123)-4567890";
		matcher = pattern2.matcher(str);
		if (matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}
}
