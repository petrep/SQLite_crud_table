// Currently I am trying to follow:
// http://www.kode-blog.com/2015/07/java-swing-jdbc-crud-example-with-jasper-reports/
// Then I decided not to use it because:
// I got "SQLite only supports TYPE_FORWARD_ONLY cursors" error message
// 
// Forum users say that it is better to use jdbc connection pooling, I choose C3PO, now I will
// Create a separate project to test connections with C3PO
// Now I have tested C3PO, and it looks like it is rather used for larger apps,
// there is no need in a small app to use multiple datasource connections.
// Connections can be reused as well.
// Possible problem: maybe reusing the same connection is causes problems in a multi-threaded env.
// Maybe this can be my new rule: if I'm using one thread, it is ok to reuse statments / connections ,
// and if I'm using multiple threads, I can use connection pooling with 3CPO

// TODO: create a table layout? review logic.. add logic for update operations, implement disconnect,
// because disconnect is currently never called

package com.test;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite_crud_table {

	static Connection conn = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws SQLException {
		System.out.println("testing starts..");
//		makeConnection();
//		runSQL();
//		closeConnection();
		FORMEntities sForm = new FORMEntities();
	}

//	public static void makeConnection() throws SQLException {
//
//		// SQLite3 section start
//		String driver = "org.sqlite.JDBC";
////		String url = "jdbc:sqlite:db\\test.db";
////		String userName = "";
////		String password = "";
//		// SQLite3 section end
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, userName, password);
//			System.out
//					.println("Connected to the database!");
//			DatabaseMetaData dbm = conn.getMetaData();
//			rs = dbm.getTables(null, null, "%", new String[] { "TABLE" });
//			while (rs.next()) {
//				//System.out.println(rs.getString("TABLE_NAME"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			rs.close();
//		}
//
//	}
//
//	private static void runSQL() throws SQLException {
//		int iTimeout = 30;
//		//String sVACUUM = "VACUUM table2";
//		String sMakeSelect = "SELECT rowid as myrowid,* FROM table2";
//
//		// create a database connection
//
//		try {
//			Statement stmt = conn.createStatement();
//			try {
//				stmt.setQueryTimeout(iTimeout);
//				//int rs2 = stmt.executeUpdate(sVACUUM);
//				ResultSet rs = stmt.executeQuery(sMakeSelect);
//				
//				try {
//					while (rs.next()) {
//						String sResult = rs.getString("myrowid");
//						System.out.println(sResult);
//					}
//				} finally {
//					try {
//						rs.close();
//					} catch (Exception ignore) {
//					}
//				}
//			} finally {
//				try {
//					stmt.close();
//				} catch (Exception ignore) {
//				}
//			}
//		} finally {
//
//		}
//	}
//
//	public static void closeConnection() throws SQLException {
//		conn.close();
//	}
}
