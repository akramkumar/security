package com.demo.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.model.Student;

@RestController
public class StudentController {
	private List<Student> students= new ArrayList<>(List.of(
			new Student((long) 1,"Ramkumar","Maths",80),
			new Student((long) 2, "Karthick","Maths",85)
			));
	
	@GetMapping("/students")
	public List<Student> getAllStudent()
	{
		return students;
	}

}
