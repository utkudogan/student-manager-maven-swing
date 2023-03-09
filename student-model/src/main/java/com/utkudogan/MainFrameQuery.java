package com.utkudogan;

import java.util.List;

public class MainFrameQuery {
	private Database database = DatabaseHandler.INSTANCE.getInstance();

	public List<Student> getAllStudents() {
		return database.getStudents();
	}
}
