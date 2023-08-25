package com.cybage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Student;
import com.cybage.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllstudent() {
		
		return studentRepository.findAll();
	}
	
	public  Optional<Student> getstudentById(int id) {
		
		return studentRepository.findById(id);
		
	}

	public void updatestudent(Student student) {
		studentRepository.save(student); 
	}
	
	
	public void deletestudentById(int id) {
		studentRepository.deleteById(id);
	}
}