package com.utkudogan.service.impl;

import java.util.List;

import com.utkudogan.Database;
import com.utkudogan.Student;
import com.utkudogan.service.MainFrameService;

public class MainFrameServiceImpl implements MainFrameService {

	private Database database;

	public MainFrameServiceImpl() {
		this.database = new Database();
	}

	@Override
	public List<Student> getStudents() {
		return database.getStudents();
	}
}
