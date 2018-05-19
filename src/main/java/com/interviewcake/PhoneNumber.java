package com.interviewcake;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {

	private static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		// ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			if (ans.size() == 0) {
				addChars(ans, mapping[x], "");
			} else {
				while (ans.peek().length() == i) {
					String t = ans.remove();
					addChars(ans, mapping[x], t);
				}
			}
		}
		return ans;
	}

	private static void addChars(LinkedList<String> ans, String str, String t) {
		for (char s : str.toCharArray())
			ans.add(t + s);
	}

	public static void main(String[] args) {
		System.out.println("Answer = " + letterCombinations("23"));
	}

}
