package com.ketul.demo.module;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	

	private int id = 0;
	
	@Size(min = 3, message = "Your name atleast 2 characters")
	@Pattern(regexp = "(^[A-Z])\\w+", message = "Your Name should contain 1st capital letter")
	private String name;

	@Min(value = 10, message = "Your age is > 10")
	@Max(value = 30, message = "Your age is < 30")
	private int age;
	
	public User() {
		super();
	}
	
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
	
	
}
