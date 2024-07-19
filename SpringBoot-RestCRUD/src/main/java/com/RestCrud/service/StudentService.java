package com.RestCrud.service;

import java.util.List;

import com.RestCrud.entity.Student;

public interface StudentService {

	void addStudent(Student student);

	List<Student> getStudents();

	Student getStudent(Integer id);

	void updateStudent(Integer id, Student student);

	void deleteStudent(Integer id);

}
