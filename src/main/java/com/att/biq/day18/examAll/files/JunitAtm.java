package com.att.biq.day18.examAll.files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JunitAtm
{
	@ParameterizedTest
	@CsvSource(
	{ "10, 10, 20, 20", "30, 20, 10, 0" })
	void testBinary(int m20Val, int m100Val, int m50Val, int m200Val) throws IOException, ClassNotFoundException
	{
		File atmFile = File.createTempFile("atm", ".bin");

		ATM atm = new ATM();
		atm.addBill(BillEnum.M20, m20Val);
		atm.addBill(BillEnum.M100, m100Val);
		atm.addBill(BillEnum.M50, m50Val);
		atm.addBill(BillEnum.M200, m200Val);

		try (FileOutputStream fos = new FileOutputStream(atmFile))
		{
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(atm);
			atm.clear();
		}

		try (FileInputStream fis = new FileInputStream(atmFile))
		{
			ObjectInputStream ois = new ObjectInputStream(fis);
			atm = (ATM) ois.readObject();
			assertEquals(atm.getAllBillCount(), 4, "Total");
			assertEquals(atm.getBillCount(BillEnum.M20), m20Val, "BillCount for M20");
			assertEquals(atm.getBillCount(BillEnum.M100), m100Val, "BillCount for M100");
			assertEquals(atm.getBillCount(BillEnum.M50), m50Val, "BillCount for M50");
			assertEquals(atm.getBillCount(BillEnum.M200), m200Val, "BillCount for M200");
		}

		atmFile.delete();
	}

	@ParameterizedTest
	@CsvSource(
	{ "10, 10, 20, 20", "30, 20, 10, 0" })
	void testText(int m20Val, int m100Val, int m50Val, int m200Val) throws IOException, ClassNotFoundException
	{
		ATM atm = new ATM();
		atm.addBill(BillEnum.M20, m20Val);
		atm.addBill(BillEnum.M100, m100Val);
		atm.addBill(BillEnum.M50, m50Val);
		atm.addBill(BillEnum.M200, m200Val);
		File atmFile = File.createTempFile("atm", ".txt");

		try (FileOutputStream fos = new FileOutputStream(atmFile))
		{
			atm.saveAsText(fos);
			atm.clear();
		}
		try (FileInputStream fis = new FileInputStream(atmFile))
		{
			atm.loadAsText(fis);
			assertThat("Total bills",atm.getAllBillCount(), is(equalTo(4)));
			assertEquals(atm.getBillCount(BillEnum.M20), m20Val, "BillCount for M20");
			assertEquals(atm.getBillCount(BillEnum.M100), m100Val, "BillCount for M100");
			assertEquals(atm.getBillCount(BillEnum.M50), m50Val, "BillCount for M50");
			assertEquals(atm.getBillCount(BillEnum.M200), m200Val, "BillCount for M200");
		}

		atmFile.delete();
	}

}
