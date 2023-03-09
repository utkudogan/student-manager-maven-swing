package com.utkudogan;

//implement a singleton pattern
// if we use a private constructor - we can use 
// reflection to create multiple objects
public enum DatabaseHandler {

	INSTANCE;

	private Database database = new Database();

	public Database getInstance() {
		return database;
	}

}
