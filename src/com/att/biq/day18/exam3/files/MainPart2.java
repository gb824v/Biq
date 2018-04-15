package com.att.biq.day18.exam3.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainPart2
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		FileOutputStream fos = new FileOutputStream(new File("atm2.txt"));
		FileInputStream fis = new FileInputStream(new File("atm2.txt"));
		ATMPart2 atmPart2 = new ATMPart2();
		atmPart2.addBill(BillEnum.M20, 2);
		atmPart2.addBill(BillEnum.M100, 2);
		atmPart2.addBill(BillEnum.M50, 2);
		atmPart2.addBill(BillEnum.M200, 2);
		atmPart2.saveAsBinary(fos);
		atmPart2.loadAsBinary(fis);
	}
}
