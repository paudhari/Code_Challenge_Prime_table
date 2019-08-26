package com.company.table.prime.controller.bdd.integration.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import org.testng.annotations.Test;

import com.company.table.prime.controller.PrimeTable;

/**
 * this class contains integration tests for PrimeTable.
 * It tests the application end to end functionalities as well as the validation test for main class.
 *
 */
public class PrimeTableTest {

	@Test
    public static  void printPrimeNumberTableTest() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
	    String numberOfPrimeNumbers = "10";
	    String numberToStartFrom = "5";
	    
		PrimeTable.main(new String[]{numberOfPrimeNumbers, numberToStartFrom});
		
		System.out.flush();
		System.setOut(old);
		String primeTable = baos.toString();
		assertNotNull(primeTable);
		assertTrue(primeTable.contains(numberToStartFrom));
		String[] lines = primeTable.split("\r\n|\r|\n");
		assertEquals(lines.length, Integer.parseInt(numberOfPrimeNumbers)+1);
    }
	
	@Test
    public static  void printPrimeNumberTableTestWithRandomNumbers() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		Random ran = new Random();
		int totalPrimeNumbers = ran.nextInt(6) + 5;
		int startingFrom = ran.nextInt(8) + 15;
	    String numberOfPrimeNumbers = String.valueOf(totalPrimeNumbers);
	    String numberToStartFrom = String.valueOf(startingFrom);
	    
		PrimeTable.main(new String[]{numberOfPrimeNumbers, numberToStartFrom});
		
		System.out.flush();
		System.setOut(old);
		String primeTable = baos.toString();
		System.out.println("Here: " + primeTable);
		assertNotNull(primeTable);
		assertTrue(primeTable.contains(numberToStartFrom));
		String[] lines = primeTable.split("\r\n|\r|\n");
		assertEquals(lines.length, Integer.parseInt(numberOfPrimeNumbers)+1);
    }
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public static void printPrimeNumberTableTestWithMoreArgs() throws IOException {
		PrimeTable.main(new String[] { "11", "22", "33" });
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public static void printPrimeNumberTableTestWithNegativeTotalNo() throws IOException {
		PrimeTable.main(new String[] { "-1", "22"});
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public static void printPrimeNumberTableTestWithInvalidNumberArgs() throws IOException {
		PrimeTable.main(new String[] { "11a", "c12"});
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public static void printPrimeNumberTableTestWithInvalidNumber2ndArgs() throws IOException {
		PrimeTable.main(new String[] { "11", "c12"});
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public static void printPrimeNumberTableTestWithInvalidNumberAndLessArgs() throws IOException {
		PrimeTable.main(new String[] { "11a"});
	}
}
