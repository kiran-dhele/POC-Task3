package com.neosoft.main.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.main.model.Student;
import com.neosoft.main.repository.StudentRepo;
import com.neosoft.main.service.ServiceInterf;

@Service
public class HomeServiceImpl implements UserDetailsService, ServiceInterf{

	@Autowired
	StudentRepo studentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		if(username.equals("admin"))
		{
			return new User("admin", "admin", new ArrayList<>());
		}
		else
		{
			return new User("student", "student", new ArrayList<>());
		}
	}

	@Override
	public Student saveStudent(Student student) {

		Student stu=studentRepo.save(student);
		return stu;
	}

}
