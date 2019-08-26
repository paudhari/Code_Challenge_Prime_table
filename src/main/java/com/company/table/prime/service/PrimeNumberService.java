package com.company.table.prime.service;

/**
 * this is the service class that find the list of prime numbers in given range by user
 */
public class PrimeNumberService {

    /**
     * finds the list of prime numbers in given range by user
     *
     * @param numPrime
     * @param startingFrom
     * @return
     */
    public int[] getPrimeNumbers(int numPrime, int startingFrom) {
        if (numPrime < 0) {
            throw new IllegalArgumentException("total response results can't be negative");
        }
        int[] primeArray = new int[numPrime];
        int i = 1;
        while (i <= numPrime) {
            if (isPrime(startingFrom)) {
                primeArray[i - 1] = startingFrom;
                i++;
            }
            startingFrom++;
        }
        return primeArray;
    }

    /**
     * Method to check if a given number is prime or not, this calculates the prime check in O(log(n))
     * @param n
     * @return true or false
     */
    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
