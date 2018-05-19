package com.anwar;

public class PrimeTest {

	static boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n == 2 || n == 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	private static void sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n];
		for (int i = 0; i < n; i++)
			if (i % 2 != 0) {
				prime[i] = true;
			}
		for (int p = 2; p <= Math.sqrt(n); p += 2) {
			if (prime[p]) {
				// Update all multiples of p
				for (int i = p * p; i <= Math.sqrt(n); i += p * 2)
					prime[i] = false;
			}
		}
		// Print all prime numbers
		for (int i = 2; i < n; i++) {
			if (prime[i] == true)
				System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		System.out.println(isPrime(9989));  
	
		sieveOfEratosthenes(10000);
	}

}
