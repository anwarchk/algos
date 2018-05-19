package com.anwar.sorting;

public class TestSorting {

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> boolean isSorted(final Comparable<T>[] data) {
		for (int i = 1; i < data.length; ++i)
			if (data[i - 1].compareTo((T) data[i]) > 0)
				return false;
		return true;
	}

	public static boolean isSorted(final int[] data) {
		for (int i = 1; i < data.length; ++i)
			if (data[i - 1] > data[i])
				return false;
		return true;
	}

	public static int[] randomData(final int length) {
		final int[] data = new int[length];
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = i;
		}
		return data;
	}

	public static int[] randomData2(final int length) {
		final int[] data = new int[length];
		int val = -(int) (Math.random() * length / 2) - 1;
		for (int i = 0; i < length; ++i) {
			final int r = (int) ((i + 1) * Math.random());
			data[i] = data[r];
			data[r] = val;
			if (Math.random() > 0.2)
				++val;
		}
		return data;
	}

}
