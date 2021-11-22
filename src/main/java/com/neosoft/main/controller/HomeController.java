package com.neosoft.main.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.main.model.Project;
import com.neosoft.main.model.Student;
import com.neosoft.main.service.ServiceInterf;

@Controller
public class HomeController {

	@Autowired
	ServiceInterf serviceInterf;
	
//After authentication student form will be open through this URL.
	@RequestMapping("/")
	public String login() {
		return "studentForm";
	}

//This request bring the student data from form and store in database.	
	@RequestMapping("/register")
	public String saveStudent(@ModelAttribute Student student, @RequestParam("projName") String[] projName) {

		Set<Project> set = new HashSet<Project>();

		Project project = null;
		int count = 0;
		for (String name : projName) {

			if (count == 0) {
				project = new Project();
				project.setProjName(name);
				count++;
			} else {
				project.setDuration(name);
				set.add(project);
				count = 0;
			}
		}
		student.setProject(set);

		Student stu = serviceInterf.saveStudent(student);
		return "Data save Successully";
	}
}
