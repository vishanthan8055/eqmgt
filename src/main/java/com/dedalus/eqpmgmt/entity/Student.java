package com.dedalus.eqpmgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "studentId" )
	private int studentId;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Column(name = "studentName", nullable = false, length = 50 )
	private String studentName;
	
	@Column(name = "marks", nullable = false )
	private int marks;
}
