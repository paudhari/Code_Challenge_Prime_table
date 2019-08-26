package com.company.table.prime.service.tdd.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Random;

import org.testng.annotations.Test;

import com.company.table.prime.service.PrimeNumberService;

/**
 * this class has test cases for PrimeNumberService
 *
 */
public class PrimeNumberServiceTest {
	
	private PrimeNumberService primeNumberService = new PrimeNumberService();

	@Test
	public void primeNumberServiceTest() {
		Random ran = new Random();
		int totalPrimeNumbers = ran.nextInt(6) + 5;
		int startingFrom = ran.nextInt(8) + 15;
		
		int[] returnedPrimeNumberArr = primeNumberService.getPrimeNumbers(totalPrimeNumbers, startingFrom);
		assertNotNull(returnedPrimeNumberArr);
		assertEquals(returnedPrimeNumberArr.length, totalPrimeNumbers);
	}
	
	@Test
	public void primeNumberServiceTestStartNumberAsNegative() {
		Random ran = new Random();
		int totalPrimeNumbers = ran.nextInt(6) + 5;
		
		int[] returnedPrimeNumberArr = primeNumberService.getPrimeNumbers(totalPrimeNumbers, -1);
		assertNotNull(returnedPrimeNumberArr);
		assertEquals(returnedPrimeNumberArr.length, totalPrimeNumbers);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void primeNumberServiceTestTotalAsNegative() {
		Random ran = new Random();
		int totalPrimeNumbers = ran.nextInt(6) + 5;
		
		primeNumberService.getPrimeNumbers(-1, totalPrimeNumbers);
	}
}
