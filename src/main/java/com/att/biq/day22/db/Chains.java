package com.att.biq.day22.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Chains {
	private int id=100;
//	/private String SELECT_CHAINS_BY_NAME = "SELECT chain_id, chain_name FROM Chains WHERE chain_name = ?";
	private String INSERT_CHAIN = "INSERT INTO Chains VALUES (?, ?,?)";
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	public Chains(Connection con) {
		this.connection = con;
	}

	public void createChain(String name,String type) throws SQLException {
		preparedStatement = connection.prepareStatement(INSERT_CHAIN);
		preparedStatement.setInt(1,++id);
		preparedStatement.setString(2,name);
		preparedStatement.setString(3,type);
		preparedStatement.executeUpdate();
	}
}
