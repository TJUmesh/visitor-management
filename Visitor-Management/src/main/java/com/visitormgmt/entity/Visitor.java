package com.visitormgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "visitors_table")
@Data


public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long visitorId;
	@NotEmpty(message = "Visitor Name should not be Empty")
	private String visitorName;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
	private String mobileNumber;

	@NotEmpty(message = "Address should not be Empty")
	private String address;

	@Min(value = 1, message = "ClassId Must be greater than or equal to 1")
	private long classId;

	@Min(value = 1, message = "StudentId Must be greater than or equal to 1")
	private long studentId;

	@NotEmpty(message = "Relation should not be Empty")
	private String relationWith;

	@NotEmpty(message = " please Enter valid Reason")
	private String reason;

	@NotEmpty(message = "pleas upload photo")
	private String photo;

	@NotEmpty(message = "Enter Time")
	private String time;

	@Size(min = 0, max = 10,message = "Invalid Date Please Enter This Formate DD/MM/YYYY")
	@NotEmpty(message="Date must not be empty")
	private String date;

	@Pattern(regexp = "^[2-9]{1}[0-9]{11}$", message = "Invalid Aadhar number")
	private String aadharNumber;

	private long schoolId;

	
}
