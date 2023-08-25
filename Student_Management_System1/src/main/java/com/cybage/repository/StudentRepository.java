package com.cybage.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findByStudentEmail(String studentEmail);

}