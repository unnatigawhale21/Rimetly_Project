package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Student;
import com.cybage.service.StudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/student")
public class StudentContoller {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<Student>addStudent(@Valid @RequestBody Student student)
	{
		Student student1 = studentService.addStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>>getAllStudent()
	{
		List<Student> studentList =  studentService.getAllstudent();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
		
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id)
	{
		Optional<Student> studentlist = studentService.getstudentById(id);	
		return new ResponseEntity<Optional<Student>>(studentlist, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updatestudent(@RequestBody Student student)
	{
		
		studentService.updatestudent(student);
		return new ResponseEntity<String>("student Updated successfully",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletestudentbyId(@PathVariable int id)
	{		
		 studentService.deletestudentById(id);
		return new ResponseEntity<String>("Record Deleted Successfully",HttpStatus.OK);
	}

}
