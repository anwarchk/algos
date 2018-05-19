package com.interviewcake.stock;

import java.util.*;

public class ArrayProduct {

	private int[] getProductsOfAllIntsExceptAtIndex(int[] arrayOfInts) {
		int[] result = new int[arrayOfInts.length];
		for (int i = 0; i < arrayOfInts.length; i++) {
			for (int j = 0; j < arrayOfInts.length; j++) {
				if (i != j) {
					result[j] = arrayOfInts[j] * arrayOfInts[j];
				} 
//				else {
//					result[i] = result[i] * arrayOfInts[j];
//				}
			}
		}
		return result;

		// Map<Integer, Integer> arrayMap = new HashMap<>();
		// int lastIndex = 0;
		// int sum = 0;
		// for(int i=0;i<arrayOfInts.length;i++) {
		// sum += sum * arrayOfInts[]
		// }
		// for(int i=0;i<arrayOfInts.length;i++) {
		// sum += arrayMap.get(i);
		// }

		// return new int[] {};

	}

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(new ArrayProduct().getProductsOfAllIntsExceptAtIndex(new int[] { 1, 7, 3, 4 })));
	}

}
