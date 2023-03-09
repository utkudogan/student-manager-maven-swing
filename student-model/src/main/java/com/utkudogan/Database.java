package com.utkudogan;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Student> students;

	public Database() {
		this.students = new ArrayList<>();
		this.students.add(new Student(1, 23, 1118, "Utku", "Turkey"));
		this.students.add(new Student(2, 24, 1116, "Utku", "Turkey"));
		this.students.add(new Student(3, 54, 11183, "Utku", "Turkey"));
		this.students.add(new Student(4, 24, 11185, "Utku", "Turkey"));
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
