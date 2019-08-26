package com.company.table.prime.util;

/**
 * this is a utility class for printing any given array in tabular form
 *
 */
public class PrimeNumberUtil {

	public static void printArrayInTabularForm(int[] primeNumbers) {
		if(primeNumbers == null ) {
			throw new IllegalArgumentException("Prime Numbers list can't be null for display");
		}
		System.out.print("\t");
		for (int i = 0; i < primeNumbers.length; i++) {
			System.out.print(primeNumbers[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < primeNumbers.length; i++) {
			System.out.print(primeNumbers[i] + "|\t");
			for (int j = 0; j < primeNumbers.length; j++) {
				System.out.print(primeNumbers[i] * primeNumbers[j] + "\t");
			}
			System.out.println();
		}
	}
}
