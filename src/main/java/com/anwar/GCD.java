package com.anwar;

public class GCD {

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		int rem = a % b;
		a = b;
		b = rem;
		return gcd(a, b);
	}

	private static int lcm(int a, int b) {
		return ((a) / gcd(a, b)) * b;
	}

	public static void main(String[] args) {
		System.out.println(gcd(78, 66));
		//System.out.println(lcm(12, 15));
	}
}
