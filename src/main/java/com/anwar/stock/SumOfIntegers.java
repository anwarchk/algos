package com.anwar.stock;

public class SumOfIntegers {
	public static void main(String args[]) {
		int sums[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10 };
		int sum = 0;
		for (int i = 0; i < sums.length; i++) {
			sum += sums[i];
		}
		System.out.println(String.format("Sum is %d", sum));
	}
}
