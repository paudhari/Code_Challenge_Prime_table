package com.company.table.prime.controller;

import com.company.table.prime.service.PrimeNumberService;
import com.company.table.prime.util.PrimeNumberUtil;

import java.util.Scanner;

/**
 * this is the controller class that prints the table for selected range of prime number table
 */
public class PrimeTable {

    /**
     * this is the start of computing and printing prime number table
     *
     * @param args
     */
    public static void main(String[] args) {
        PrimeNumberService primeNumberService = new PrimeNumberService();
        int numPrime = 10;
        int start = 1;
        if (args.length >= 1) {
            if (args.length > 2) {
                throw new IllegalArgumentException("Only upto 2 argument is accepted");
            }
            try {
                numPrime = Integer.valueOf(args[0]);
                start = args.length > 1 ? Integer.valueOf(args[1]) : 1;
            } catch (NumberFormatException ne) {
                throw new NumberFormatException("Only Numbers are accepted in input");
            }
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the Num of Prime Number");
            numPrime = in.nextInt();
            in.close();
        }
        PrimeNumberUtil.printArrayInTabularForm(primeNumberService.getPrimeNumbers(numPrime, start));
    }


}
