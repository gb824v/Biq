package com.att.biq.day18.exam3.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainPart1
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{

		ATMPart1 atm = new ATMPart1();
		atm.addBill(BillEnum.M20, 2);
		atm.addBill(BillEnum.M100, 2);
		atm.addBill(BillEnum.M50, 2);
		atm.addBill(BillEnum.M200, 2);
		System.out.println("Total: " + atm.getAllBillCount());
		System.out.println("TotalAmount: " + atm.getTotalAmount());
		System.out.println(atm.getBills());
		System.out.println("BillCount for M200: " + atm.getBillCount(new Bill(BillEnum.M200)));
		System.out.println(atm.getAvalebleBill());

		FileOutputStream fos = new FileOutputStream(new File("atm.bin"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Write objects to file
		oos.writeObject(atm);
		
		atm.clear();

		atm.addBill(BillEnum.M20, 5);
		atm.addBill(BillEnum.M100, 10);
		atm.addBill(BillEnum.M50, 12);
		atm.addBill(BillEnum.M200, 32);
		
		oos.writeObject(atm);
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream(new File("atm.bin"));
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Read objects
		ATMPart1 atm1 = (ATMPart1) ois.readObject();
		ATMPart1 atm2 = (ATMPart1) ois.readObject();

		System.out.println("Total: " + atm1.getAllBillCount());
		System.out.println("TotalAmount: " + atm1.getTotalAmount());
		System.out.println(atm1.getBills());
		System.out.println("BillCount for M200: " + atm1.getBillCount(new Bill(BillEnum.M200)));
		System.out.println(atm1.getAvalebleBill());

		
		System.out.println("Total: " + atm2.getAllBillCount());
		System.out.println("TotalAmount: " + atm2.getTotalAmount());
		System.out.println(atm2.getBills());
		System.out.println("BillCount for M200: " + atm2.getBillCount(new Bill(BillEnum.M200)));
		System.out.println(atm2.getAvalebleBill());
		fis.close();
		ois.close();

	}
}
