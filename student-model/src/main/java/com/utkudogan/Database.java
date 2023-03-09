package com.utkudogan;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Student> students;

	public Database() {
		this.students = new ArrayList<>();
	}
	
	public void add(Student student) {
		this.students.add(student);
	}
	
	public List<Student> getStudents(){
		return this.students;
	}
	
	public void remove(Student student) {
		this.students.remove(student);
	}
}
