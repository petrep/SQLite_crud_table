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

			resultSet = statement.executeQuery(sql_stmt);

			try {
				while (resultSet.next()) {
					sResult = resultSet.getInt("max(rowid)");
				}
			} finally {
				try {
					resultSet.close();
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

	public void disconnectFromDatabase() {
		if (connection != null) {
			try {
				if (resultSet == null) {
//					   System.out.println("No records found");
					} else {
						resultSet.close();
					}
				if (statement == null) {
//					   System.out.println("No records found");
					} else {
						statement.close();
					}

				connection.close();
			} catch (SQLException sqlexception) {
				System.out.println(sqlexception.getMessage());
			} finally {
				System.out.println("disconnected");
			}
		}
	}

}
