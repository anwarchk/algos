package com.anwar.stock;

public class StockQuote {

	private int getMaximumProfit(int stockesQuotes[]) {
		if (stockesQuotes.length < 2) {
			throw new IllegalArgumentException("Not valid stock quotes");
		}
		int maxProfit = stockesQuotes[1] - stockesQuotes[0];
		int lowestPrice = stockesQuotes[0];
		for (int i = 1; i < stockesQuotes.length; i++) {
			maxProfit = Math.max(maxProfit, stockesQuotes[i] - lowestPrice);
			System.out.println(String.format("Max profit = %d", maxProfit));
			lowestPrice = Math.min(lowestPrice, stockesQuotes[i]);
			System.out.println(String.format("Min price = %d", lowestPrice));
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		StockQuote stockQuote = new StockQuote();
		int[] stockQuotes = new int[] { 10, 7, 5, 8, 11, 9 };
		//System.out.println(String.format("Maximum profit is : %d", stockQuote.getMaximumProfit(stockQuotes)));
		stockQuotes = new int[] { 8, 8, 8, 8, 8, 8 };
		//System.out.println(String.format("Maximum profit is : %d", stockQuote.getMaximumProfit(stockQuotes)));
		stockQuotes = new int[] { 8, 6, 3, 2, 1, 0 };
		System.out.println(String.format("Maximum profit is : %d", stockQuote.getMaximumProfit(stockQuotes)));
	}
}
