package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTableModel {

	private Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	private boolean connectedToDatabase = false;

	private void SetDatabaseURL() throws SQLException {
		try {
			connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID,
					Config.DATABASE_PASSWORD);
		} catch (SQLException sqlexception) {
			System.out.println(sqlexception.getMessage());
		}
	}

	public ResultSetTableModel(String query) throws SQLException {

		SetDatabaseURL();
		connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID,
				Config.DATABASE_PASSWORD);

		// statement =
		// connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		// ResultSet.CONCUR_READ_ONLY);
		statement = connection.createStatement();

		connectedToDatabase = true;

		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		resultSet = statement.executeQuery(query);
		int iTimeout = 30;

		try {
			statement.setQueryTimeout(iTimeout);
			// int rs2 = stmt.executeUpdate(sVACUUM);
			ResultSet rs = statement.executeQuery(query);

			try {
				while (rs.next()) {
					String sResult = rs.getString("orig");
					String sResult2 = rs.getString("translated");
					System.out.println(sResult + " " + sResult2);
				}
			} finally {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
		} finally {
			try {
				statement.close();
			} catch (Exception ignore) {
			}
		}
		disconnectFromDatabase();
		// metaData = resultSet.getMetaData();
		// resultSet.last();
		// numberOfRows = resultSet.getRow();
		//
		// System.out.println("nr of rows: " + numberOfRows);

		// fireTableStructureChanged();

	}

	public int getColumnCount() throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			return metaData.getColumnCount();
		} catch (SQLException sqlexception) {
			System.out.println(sqlexception.getMessage());
		}

		return 0;
	}

	public String getColumnName(int column) throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sqlexception) {
			System.out.println(sqlexception.getMessage());
		}

		return "";
	}

	public int getRowCount() throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		return numberOfRows;
	}

	public Object getValueAt(int row, int column) throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		} catch (SQLException sqlexception) {
			System.out.println(sqlexception.getMessage());
		}

		return "";
	}

	
	
	
	public void disconnectFromDatabase() {
		if (connectedToDatabase) {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlexception) {
				System.out.println(sqlexception.getMessage());
			} finally {
				connectedToDatabase = false;
			}
		}
	}

}
