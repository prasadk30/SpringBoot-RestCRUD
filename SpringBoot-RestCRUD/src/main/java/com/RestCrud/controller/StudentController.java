package com.RestCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.RestCrud.entity.Student;
import com.RestCrud.repository.StudentRepository;
import com.RestCrud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;

	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		
		studentService.addStudent(student);
		return "Student added...";
	}
	
	@GetMapping
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/get")
	public Student getStudent(@RequestParam Integer id) {
		return studentService.getStudent(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateStudent(@PathVariable Integer id, @RequestBody Student student){
		studentService.updateStudent(id,student);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
}
