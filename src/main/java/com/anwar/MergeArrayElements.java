package com.anwar;

public class MergeArrayElements {

	// [2,3,4,5]
	// [4,6]
	// [1,2,3,4]
	//
	// [2,4,1,3,6,2,4,3,5,4]

	private static int[] printMatrix(int arr1[], int arr2[], int arr3[]) {
		int[] merged = new int[arr1.length + arr2.length + arr3.length];
		int m = arr1.length;
		int n = arr2.length;
		int o = arr3.length;
		int i = 0, j = 0, k = 0, l = 0;

		while (i < m && j < n && k < o) {
			merged[l++] = arr1[i++];
			merged[l++] = arr2[j++];
			merged[l++] = arr3[k++];
		}
		while (i < m) {
			merged[l++] = arr1[i++];
		}
		while (j < n) {
			merged[l++] = arr2[j++];
		}
		while (k < o) {
			merged[l++] = arr3[k++];
		}
		return merged;
	}

	public static void main(String args[]) {
		int arr2[] = { 2, 3, 4, 5 };
		int arr1[] = { 4, 6 };
		int arr3[] = { 1, 2, 3, 4 };

		int[] merged = printMatrix(arr1, arr2, arr3);

		System.out.println("Array after merging");
		for (int i = 0; i < merged.length; i++)
			System.out.print(merged[i] + " ");
	}
}
