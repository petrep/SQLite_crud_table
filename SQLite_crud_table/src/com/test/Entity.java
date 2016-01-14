//package com.test;
//
//import java.awt.Cursor;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Entity {
//
//	// All Static variables
//	// Database Version
//	private static final int DATABASE_VERSION = 1;
//
//	// Database Name
//	private static final String DATABASE_NAME = "Entities_DataBase";
//
//	// Contacts table name
//	private static final String TABLE_CONTACTS = "Entities_Table";
//
//	// Contacts Table Columns names
//	private static final String KEY_ID = "id";
//	private static final String ORIGINAL_WORD = "originalEntity";
//	private static final String TRANSLATED_WORD = "translatedEntity";
//	
//	// Other variables
//	private Connection connection;
//	//public static final String DATABASE_NAME = "employees";
////    public static final String DATABASE_SERVER = "localhost";
////    public static final String DATABASE_USER_ID = "root";
////    public static final String DATABASE_PASSWORD = "melody";
//
//    //public static final String connection_url = "jdbc:mysql://" + DATABASE_SERVER + "/" + DATABASE_NAME;
//
//
//	// public DataBase(Context context) {
//	// super(context, DATABASE_NAME, null, DATABASE_VERSION);
//	// }
//
//	// Creating Tables
//	// @Override
//	// public void onCreate(SQLiteDatabase db) {
//	// String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
//	// + KEY_ID + " INTEGER PRIMARY KEY," + ORIGINAL_WORD + " TEXT,"
//	// + TRANSLATED_WORD + " TEXT" + ")";
//	// db.execSQL(CREATE_CONTACTS_TABLE);
//	// }
//
//	// Upgrading database
//	// @Override
//	// public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
//	// {
//	// // Drop older table if existed
//	// db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//	//
//	// // Create tables again
//	// onCreate(db);
//	// }
//
//	/**
//	 * All CRUD(Create, Read, Update, Delete) Operations
//	 */
//
//	// Adding new entity
//	// void addEntity(Entity entity) {
//	// SQLiteDataSource db =
//	//
//	// ContentValues values = new ContentValues();
//	//
//	// values.put(ORIGINAL_WORD, entities.getOriginalEntity()); // Contact Name
//	// values.put(TRANSLATED_WORD, entities.getTranslatedEntity()); // Contact
//	// Phone
//	//
//	// // Inserting Row
//	// db.insert(TABLE_CONTACTS, null, values);
//	// db.close(); // Closing database connection
//	// }
//
//	// Getting single WORD
//	Entity getEntity(int id) {
//		// SQLiteDatabase db = this.getReadableDatabase();
//		Object connection = DriverManager.getConnection(SQLite_crud_table.url,
//				Config.DATABASE_USER_ID, Config.DATABASE_PASSWORD);
//
//		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
//				ORIGINAL_WORD, TRANSLATED_WORD }, KEY_ID + "=?",
//				new String[] { String.valueOf(id) }, null, null, null, null);
//		if (cursor != null)
//			cursor.moveToFirst();
//
//		Entities entities = new Entities(Integer.parseInt(cursor.getString(0)),
//				cursor.getString(1), cursor.getString(2));
//		// return contact
//		return entities;
//	}
//
//	// Getting All entities
//	public List<Entities> getAllContacts() {
//		List<Entities> contactList = new ArrayList<Entities>();
//		// Select All Query
//		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				Entities entities = new Entities();
//				entities.setID(Integer.parseInt(cursor.getString(0)));
//				entities.setOriginalEntity(cursor.getString(1));
//				entities.setTranslatedEntity(cursor.getString(2));
//				// Adding contact to list
//				contactList.add(entities);
//			} while (cursor.moveToNext());
//		}
//
//		// return contact list
//		return contactList;
//	}
//
//	// Updating single contact
//	public int updateEntity(Entities entities) {
//		SQLiteDatabase db = this.getWritableDatabase();
//
//		ContentValues values = new ContentValues();
//		values.put(ORIGINAL_WORD, entities.getOriginalEntity());
//		values.put(TRANSLATED_WORD, entities.getTranslatedEntity());
//
//		// updating row
//		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//				new String[] { String.valueOf(entities.getID()) });
//	}
//
//	// Deleting single contact
//	public void deleteEntity(Entities entities) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//				new String[] { String.valueOf(entities.getID()) });
//		db.close();
//	}
//
//	// Getting contacts Count
//	public int getEntitiesCount() {
//		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(countQuery, null);
//		cursor.close();
//
//		// return count
//		return cursor.getCount();
//	}
//
//}
