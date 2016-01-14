package com.test;

import java.sql.SQLException;
import java.util.Scanner;

public class FORMEntities {

	public FORMEntities() throws SQLException {

		initComponents();
	}

	private void initComponents() throws SQLException {
		String sql_stmt = "SELECT * FROM table2;";

		// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("1 - List the content of the table");
		System.out.println("2 - Add a new row");
		System.out.println("3 - Delete a row");
		System.out.println("Enter your selection: ");
		int n = reader.nextInt();
		System.out.println("You have entered: " + n);

		if (n == 1) {
			ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
		}
		if (n == 2) {
			addRow();
		}
		if (n == 3) {
			System.out.println("Type the row ID to delete: ");
			int deleteRowIndex = reader.nextInt();
			System.out.println("This row will be deleted: " + deleteRowIndex);
			deleteRow(deleteRowIndex);
		}

	}

	
	private void addRow() throws SQLException {
		// String sql_stmt = "INSERT INTO table2 (orig, translated) VALUES
		// (a9,b9 );";

		String sql_stmt = "INSERT INTO `table2`(`col1`,`col2`)";

		// sql_stmt += " VALUES ('" + txtFullName.getText() + "','" +
		// cboGender.getSelectedItem().toString() + "','" +
		// txtDepartment.getText() + "','" + txtPosition.getText() + "','" +
		// txtSalary.getText() + "')";
		int newRowid = getLastRowid() + 1;
		System.out.println("newrowid: " + newRowid);
		sql_stmt += " VALUES ('a" + newRowid + "','b" + newRowid + "')";
		DBUtilities dbUtilities = new DBUtilities();

		dbUtilities.ExecuteSQLStatement(sql_stmt);
		// dbUtilities.disconnectFromDatabase();
		
		// I think this is the place to update the table, like:
		// fireTableStructureChanged();  or
		// loadTable();
	}

	private int getLastRowid() throws SQLException {
		String sql_stmt = "SELECT max(rowid) FROM table2;";

		DBUtilities dbUtilities = new DBUtilities();
		int lastRowid = dbUtilities.ExecuteSingleSQLStatement(sql_stmt);
		return lastRowid;
	}
	
	private void deleteRow(int deleteRowIndex) throws SQLException {
		String vacuum_stmt = "VACUUM 'table2'";
		String sql_stmt = "DELETE FROM `table2` WHERE `_rowid_`='"+ deleteRowIndex + "';";

		DBUtilities dbDeleteRow = new DBUtilities();
		dbDeleteRow.ExecuteSQLStatement(vacuum_stmt);
		dbDeleteRow.ExecuteSQLStatement(sql_stmt);	
		dbDeleteRow.ExecuteSQLStatement(vacuum_stmt);
		
		// I think this is the place to update the table, like:
		// fireTableStructureChanged();  or
		// loadTable();
	}

	private void updateRow(int deleteRowIndex) throws SQLException {
//		String vacuum_stmt = "VACUUM 'table2'";
//		String sql_stmt = "DELETE FROM `table2` WHERE `_rowid_`='"+ deleteRowIndex + "';";
//
//		DBUtilities dbDeleteRow = new DBUtilities();
//		dbDeleteRow.ExecuteSQLStatement(vacuum_stmt);
//		dbDeleteRow.ExecuteSQLStatement(sql_stmt);	
//		dbDeleteRow.ExecuteSQLStatement(vacuum_stmt);
		
		// I think this is the place to update the table, like:
		// fireTableStructureChanged();  or
		// loadTable();
	}


}
