package com.utkudogan;

public class Student {

	
	private int id;
	private int age;
	private int zipCode;
	private String name;
	private String country;

	public Student() {

	}

	public Student(int id, int age, int zipCode, String name, String country) {
		this.id = id;
		this.age = age;
		this.zipCode = zipCode;
		this.name = name;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", country=" + country + "]";
	}

}
