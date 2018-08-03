package com.dev.hibernate.mapping.onetoone.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.hibernate.mapping.onetoone.model.Student;
import com.dev.hibernate.mapping.onetoone.model.StudentDetails;

public class SharedPrimaryKeyMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.sessionFactory;

		Session session = sessionFactory.openSession();

		Student student = new Student();
		student.setAge(14);
		student.setFatherName("Ganesan");
		student.setGender("Male");
		student.setMotherName("Vembu");
		student.setName("Rohan");

		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setClassNo(9);
		studentDetails.setMajorSubject("Science");
		studentDetails.setRollNo(15);
		studentDetails.setTeacherName("DavidRaj");
		student.setStudentDetails(studentDetails);
		studentDetails.setStudent(student);

		session.beginTransaction();

		session.save(studentDetails);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
	}

}
