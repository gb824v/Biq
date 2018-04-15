package com.att.biq.day22.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public abstract class DbBase {

	MysqlDataSource ds;
	Connection conn = null;
	Statement stmt = null;

	public DbBase() throws SQLException, InvalidPropertiesFormatException, FileNotFoundException, IOException {
		getProperties();
	}

	public Connection getConn() {
		return conn;
	}

	private void getProperties() throws SQLException, InvalidPropertiesFormatException, FileNotFoundException, IOException {
		ds = new MysqlDataSource();
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("properties.xml");
		Properties dbProps = new Properties();
		dbProps.loadFromXML(is);
		ds.setServerName(dbProps.getProperty("serverName"));
		ds.setPortNumber(Integer.parseInt(dbProps.getProperty("serverPort")));
		ds.setDatabaseName(dbProps.getProperty("dbName"));
		ds.setUser(dbProps.getProperty("user"));
		ds.setPassword(dbProps.getProperty("password"));
		conn = ds.getConnection();
	}
}
