package com.RestCrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.RestCrud.entity.Student;
import com.RestCrud.repository.StudentRepository;
import com.RestCrud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
		Student student=studentRepository
				.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid id"+id));
		return student;
	}

	@Override
	public void updateStudent(Integer id, Student student) {
		// check user is in Database or not
		studentRepository.findById(id)
						 .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Id"+id) );
		student.setId(id);
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(Integer id) {
		
		studentRepository.findById(id)
		  				 .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Id"+id) );
		studentRepository.deleteById(id);
	}

}
