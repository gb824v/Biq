package com.att.biq.day22.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public abstract class DbBase
{

	MysqlDataSource ds;
	Connection conn = null;
	Statement stmt = null;
	private final String SERVER_NAME = "localhost";
	private final int SERVER_PORT = 3306;
	private final String DB_NAME = "chains_of_stores";
	private final String USER = "root";
	private final String PASSWORD = "1234";

	public DbBase() throws SQLException
	{
		ds = new MysqlDataSource();
		ds.setServerName(SERVER_NAME);
		ds.setPortNumber(SERVER_PORT);
		ds.setDatabaseName(DB_NAME);
		ds.setUser(USER);
		ds.setPassword(PASSWORD);
		conn = ds.getConnection();
	}
	public Connection getConn()
	{
		return conn;
	}
}
