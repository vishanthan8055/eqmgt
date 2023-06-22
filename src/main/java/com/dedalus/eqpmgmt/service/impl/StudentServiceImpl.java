package com.dedalus.eqpmgmt.service.impl;

import org.springframework.stereotype.Service;

import com.dedalus.eqpmgmt.entity.Student;
import com.dedalus.eqpmgmt.repository.StudentRepository;
import com.dedalus.eqpmgmt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository; 
	StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}

}
