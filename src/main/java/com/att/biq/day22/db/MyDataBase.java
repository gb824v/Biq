package com.att.biq.day22.db;

import java.io.IOException;
import java.sql.SQLException;

public class MyDataBase extends DbBase {

	public MyDataBase() throws IOException {
		super();
	}

	public static void main(String[] args) throws IOException, SQLException {
		MyDataBase myDb = new MyDataBase();
		myDb.connect();

	}

}
