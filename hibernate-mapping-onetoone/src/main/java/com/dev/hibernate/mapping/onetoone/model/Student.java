package com.dev.hibernate.mapping.onetoone.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5264899100097407980L;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "gender")
	private String gender;

	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName="student_details_id")
	private StudentDetails studentDetails;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", gender=" + gender + "]";
	}

}
