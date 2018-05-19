package com.interviewcake;

import java.util.*;

public class ProductOfNumbers {

	private static int[] getNumberProduct(int[] array) {
		int sum = 0;
		int[] results = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j) {
					if (sum == 0) {
						sum = array[j];
					} else {
						sum = sum * array[j];
					}
				}
			}
			results[i] = sum;
			sum = 0;
		}
		return results;
	}

	public static void main(String[] args) {
		//
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
		// PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int[] array = new int[] { 1, 7, 3, 4 };
		System.out.println(Arrays.toString(getNumberProduct(array)));
		pq.add(2);
		pq.add(10);
		pq.add(9);
		Integer val;
		while ((val = pq.poll()) != null) {
			System.out.println(val);
		}
		// System.out.println(Arrays.toString(pq.toArray()));
		// System.out.println((11 & 1) == 0 ? "EVEN" : "ODD" );
		// System.out.println((int)Math.floor(Math.log10(1000000000)) + 1);

		int a = 5, b = 6;

		a ^= b;
		
		System.out.println("a = " + a + " b = " + b);

		b ^= a;

		System.out.println("a = " + a + " b = " + b);

		a ^= b;

		System.out.println("a = " + a + " b = " + b);

	}
}
