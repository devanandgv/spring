package com.dev.hibernate.mapping.onetoone.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "student_details")
public class StudentDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5341719497256373774L;

	@Id
	@Column(name = "student_details_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "roll_no")
	private int rollNo;

	@Column(name = "class")
	private int classNo;

	@Column(name = "teacher_name")
	private String teacherName;

	@Column(name = "major_subject")
	private String majorSubject;

	@OneToOne(mappedBy="studentDetails",cascade=CascadeType.ALL)
	private Student student;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", rollNo=" + rollNo + ", classNo=" + classNo + ", teacherName="
				+ teacherName + ", majorSubject=" + majorSubject + "]";
	}
	
	

}
