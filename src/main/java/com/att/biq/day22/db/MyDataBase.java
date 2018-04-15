package com.att.biq.day22.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

public class MyDataBase extends DbBase
{

	public MyDataBase() throws SQLException, InvalidPropertiesFormatException, FileNotFoundException, IOException {
		super();
	}
	public static void main(String[] args) throws IOException, SQLException
	{
		MyDataBase myDb = new MyDataBase();
		
	}
	
	
}
