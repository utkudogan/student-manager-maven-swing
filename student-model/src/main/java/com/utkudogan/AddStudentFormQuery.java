package com.utkudogan;

public class AddStudentFormQuery {
private Database database = DatabaseHandler.INSTANCE.getInstance();

public void insert(Student student) {
	this.database.add(student);
}
}
