package com.utkudogan.service.impl;

import java.util.List;

import com.utkudogan.Database;
import com.utkudogan.MainFrameQuery;
import com.utkudogan.Student;
import com.utkudogan.service.MainFrameService;

public class MainFrameServiceImpl implements MainFrameService {

	private MainFrameQuery query;

	public MainFrameServiceImpl() {
		this.query = new MainFrameQuery();
	}

	@Override
	public List<Student> getStudents() {
		return query.getAllStudents();
	}
}
