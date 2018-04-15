package com.att.biq.day22.db;

import java.io.IOException;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataBase extends DbBase
{
	MysqlDataSource ds;

	public MyDataBase() throws SQLException
	{
		super();
		stmt.executeUpdate("INSERT INTO GroupsOfChains VALUES (101, 'Elit', '55');");
	}

	public static void main(String[] args) throws IOException, SQLException
	{
		MyDataBase md = new MyDataBase();
	}

	
	
	
}
