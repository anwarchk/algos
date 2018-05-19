package com.anwar;

public class StringInPlace {

	private String reverseInPlace(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char temp = s.charAt(i);
			chars[i] = s.charAt(j);
			chars[j] = temp;
		}
		Integer.parseInt("12121");
		return String.valueOf(chars);
	}

	private static void reverseWords(char[] message) {
		for (int i = 0, j = message.length -1; i < j ; i++, j--) {
			if (message[i] == ' ') {
				continue;
			}
			char temp = message[i];
			message[i] = message[j];
			message[j] = temp;
		}
	}

	public static void main(String[] args) {
		//String s = "anwar";
		//System.out.println("Reversed string :" + new StringInPlace().reverseInPlace(s));

		char[] message = { 'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l' };
		reverseWords(message);

		System.out.println(message);

	}

}
