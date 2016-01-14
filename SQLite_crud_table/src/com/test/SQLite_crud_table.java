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

// Update method is now working, the disconnect method as well.
// For now, I decided to leave this project as is, it is working, and I don't necessarily need to 
// implement a swing table at this point.

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLite_crud_table {

	static Connection conn = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws SQLException {
		System.out.println("testing starts..");
		FORMEntities sForm = new FORMEntities();
	}
}
