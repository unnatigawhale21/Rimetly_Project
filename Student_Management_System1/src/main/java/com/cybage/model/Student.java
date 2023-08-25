package com.cybage.model;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	@Column(name = "student_id", nullable = false)
	private int studentId;
	
	@NotNull
	@Size(min = 2, message = "Student name must have at least 2 characters")
	@Column(name = "student_name", nullable = false)
	private String studentName;
	
	
	@NotNull
	@Email
	@Column(name = "student_email", nullable = false)
	private String studentEmail;
	
	
	@NotNull
	@Column(name = "student_address",nullable = false)
	private String studentAddress;



}
