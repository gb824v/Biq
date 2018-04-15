package com.att.biq.day22.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataBase
{
	MysqlDataSource ds;

	public MyDataBase() throws SQLException
	{
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setDatabaseName("chains_of_stores");
		ds.setUser("root");
		ds.setPassword("1234");

		Connection conn = ds.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO GroupsOfChains VALUES (101, 'Elit', '55');");
	}

	public static void main(String[] args) throws IOException, SQLException
	{
		MyDataBase md = new MyDataBase();
	}

}
