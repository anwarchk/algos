package com.interviewcake;

public class PalindromeNumber {

	private boolean isPalindromeRec(int x, int y) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		if (isPalindromeRec(x / 10, y) && (x % 10 == y % 10)) {
			y /= 10;
			return true;
		} else {
			return false;
		}
	}

	private boolean isPalindrome(int x) {
		return isPalindromeRec(x, x);
	}
	
	private static boolean isPalindromeNonRec(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
			System.out.println("Div :" + div);

		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	private static int reverse(int num) {
		assert (num >= 0); // for non-negative integers only.
		int rev = 0;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			System.out.println("Reverse :" + rev);
			num /= 10;
		}
		return rev;
	}

	

	public static void main(String[] args) {
		System.out.println("Reversed number is " + isPalindromeNonRec(1771));
	}

}
