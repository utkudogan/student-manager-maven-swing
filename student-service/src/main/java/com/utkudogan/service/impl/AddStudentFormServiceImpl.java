package com.utkudogan.service.impl;

import com.utkudogan.AddStudentFormQuery;
import com.utkudogan.Student;
import com.utkudogan.service.AddStudentFormService;

public class AddStudentFormServiceImpl implements AddStudentFormService {
	private AddStudentFormQuery query;

	public AddStudentFormServiceImpl() {
		this.query = new AddStudentFormQuery();
	}

	@Override
	public void insert(Student student) {
		this.query.insert(student);
	}

}
