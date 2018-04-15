package com.att.biq.day10.test1.atm;

import java.util.ArrayList;
import java.util.Map;

public class Main
{
	public static void main(String[] args)
	{
		ATM atm = new ATM();
		atm.addBill(BillEnum.M20, 2);
		atm.addBill(BillEnum.M100, 2);
		atm.addBill(BillEnum.M50, 2);
		atm.addBill(BillEnum.M200, 2);
		System.out.println("Total: " + atm.getAllBillCount());
		System.out.println("TotalAmount: " + atm.getTotalAmount());
		System.out.println(atm.getBills());
		System.out.println("BillCount for M200: " + atm.getBillCount(new Bill(BillEnum.M200)));
		System.out.println(atm.getAvalebleBill());

		ATM atm1 = new ATM();
		atm1.addBill(BillEnum.M20, 2);
		atm1.addBill(BillEnum.M100, 2);
		atm1.addBill(BillEnum.M50, 2);
		atm1.addBill(BillEnum.M200, 2);

		ArrayList<ATM> atms = new ArrayList<ATM>();
		atms.add(atm);
		atms.add(atm1);
		Map<String, ArrayList<Bill>> shouldFill = ATM.allAtmsShouldFill(atms);
		System.out.println(shouldFill);
	}
}
