package com.test;

import java.sql.*;

public class DBUtilities {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public DBUtilities() throws SQLException {
		try {
			connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID,
					Config.DATABASE_PASSWORD);

		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void ExecuteSQLStatement(String sql_stmt) {
		try {
			statement = connection.createStatement();

			statement.executeUpdate(sql_stmt);
		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		}
	}

	public int ExecuteSingleSQLStatement(String sql_stmt) throws SQLException {
		int sResult = 0;
		try {
			statement = connection.createStatement();

		ResultSet rs2 = statement.executeQuery(sql_stmt);

		try {
			while (rs2.next()) {
				sResult = rs2.getInt("max(rowid)");
			}
		} finally {
			try {
				rs2.close();
			} catch (Exception ignore) {
			}
		}
	} finally {
		try {
			statement.close();
		} catch (Exception ignore) {
		}
	}

		return sResult;
	}
	
	

//	public void disconnectFromDatabase() {
//		if (connection != null) {
//			try {
//				resultSet.close();
//				statement.close();
//				connection.close();
//			} catch (SQLException sqlexception) {
//				System.out.println(sqlexception.getMessage());
//			} finally {
//				System.out.println("disconnected");
//			}
//		}
//	}

}
