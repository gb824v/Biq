package com.att.biq.day16.junit.arithmetic;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArithmeticTests
{
	@ParameterizedTest(name = "testIsPrime")
	@CsvSource({ "4","6","7" })
	public void testIsPrime(int number)
	{
		Arithmetic arithmetic = new Arithmetic();
		assertTrue(arithmetic.isPrime(number));
	}
}