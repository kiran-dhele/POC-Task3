package com.neosoft.main.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.neosoft.main.model.Student;

public interface ServiceInterf {

	public Student saveStudent(Student student);
}
