package com.dedalus.eqpmgmt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dedalus.eqpmgmt.entity.Student;
import com.dedalus.eqpmgmt.service.StudentService;

@RestController
public class StudentController {
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		System.out.println("StudentController");
		this.studentService = studentService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		System.out.println("saveStudent");
		return new ResponseEntity<Student>(this.studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
}
