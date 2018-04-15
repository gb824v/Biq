package com.att.biq.day16.junit.towersofhanoi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TowersOfHanoiTests
{
	@ParameterizedTest(name = "testTowersOfHanoiTests")
	@CsvSource({ "4,A,B,C" })
	public void testTowersOfHanoiTests(int n, String startPole, String middlePole, String endPole)
	{
		TowersOfHanoi.move(n, startPole, middlePole, endPole);
	}
}