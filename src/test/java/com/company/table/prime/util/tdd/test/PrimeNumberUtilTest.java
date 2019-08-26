package com.company.table.prime.util.tdd.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import com.company.table.prime.util.PrimeNumberUtil;

/**
 * this class has test cases for PrimeNumberUtil
 *
 */
public class PrimeNumberUtilTest {

	@Test
	public void printArrayInTabularFormTest() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		int[] arr = IntStream.range(1, 10).toArray();
		PrimeNumberUtil.printArrayInTabularForm(arr);
		
		System.out.flush();
		System.setOut(old);
		String primeTable = baos.toString();
		System.out.println("Here: " + primeTable);
		assertNotNull(primeTable);
		assertTrue(primeTable.contains("9|	9	18	27	36	45	54	63	72	81"));
		String[] lines = primeTable.split("\r\n|\r|\n");
		assertEquals(lines.length, 10);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void printArrayInTabularFormTestWithNullParam() {
		PrimeNumberUtil.printArrayInTabularForm(null);
	}
	
	@Test
	public void printArrayInTabularFormTestWithEmptyList() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		PrimeNumberUtil.printArrayInTabularForm(new int[] {});
		
		System.out.flush();
		System.setOut(old);
		String primeTable = baos.toString();
		assertTrue(primeTable.equals("\t\n"));
	}
}
