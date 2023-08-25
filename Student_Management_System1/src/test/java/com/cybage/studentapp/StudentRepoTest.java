package com.cybage.studentapp;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cybage.model.Student;
import com.cybage.repository.StudentRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepoTest {

	@Autowired
	StudentRepository studentRepository; 
	
		@Test
		@Order(1)
		@Rollback(value = false)
		public void saveStudentTest() {
			
			
			
			Student student = Student.builder()
					.studentAddress("Pune")
					.studentEmail("shrutika@gmail.com")
					.studentName("Shrutika Bhatkar")
					.build();
			
			studentRepository.save(student);
			Assertions.assertThat(student.getStudentId()).isGreaterThan(0);
		
	}
			
		@Test
		@Order(2)
		@Rollback(value = false)
		public void getStudentTest() {
			
			Student student = studentRepository.findById(1).get();
			Assertions.assertThat(student.getStudentId()).isEqualTo(1);
			
		}
		
		@Test
		@Order(3)
		@Rollback(value = false)
		public void getListOfStudentTest(){
			
		 List<Student> student = studentRepository.findAll();
         Assertions.assertThat(student.size()).isGreaterThan(0);		
		
		}
		
		@Test
		@Order(4)
		@Rollback(value = false)
		public void updateStudentTest() {
			
			Student student = studentRepository.findById(1).get();
			student.setStudentEmail("kushal@gmail.com");
			Student studentUpdated = studentRepository.save(student);
			Assertions.assertThat(studentUpdated.getStudentEmail()).isEqualTo("kushal@gmail.com");
			
		}
		
		@Test
		@Order(5)
		@Rollback(value = false)
		public void deleteStudentTest() {
			
			Student student = studentRepository.findById(1).get();
			studentRepository.delete(student);
			Student student1 = null;
			Optional<Student> optionalStudent = studentRepository.findByStudentEmail("kushal@gmail.com");
			
			if(optionalStudent.isPresent()) {
				
				student1 = optionalStudent.get();
	
			}
			
			Assertions.assertThat(student1).isNull();
			
		}

	}


