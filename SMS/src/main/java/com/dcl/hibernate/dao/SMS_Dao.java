package com.dcl.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dcl.hibernate.entity.Course;
import com.dcl.hibernate.entity.Department;
import com.dcl.hibernate.entity.Student;
import com.dcl.hibernate.entity.Teacher;

public class SMS_Dao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	Scanner sc = new Scanner(System.in);
	
	public void addStudent() {
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter department id");
		Department dept = em.find(Department.class, sc.nextInt());
		if(dept!=null) {
			Student student = new Student();
			System.out.println("Enter student id");
			int id = sc.nextInt();
			student.setStu_id(id);
			System.out.println("Enter student name");
			student.setStu_name(sc.next());
			System.out.println("Enter student email");
			student.setStu_email(sc.next());
			student.setDepartment(dept);
			et.begin();
			
			em.persist(student);
			
			et.commit();
		}else {
			System.out.println("Department does not exist");
		}
		em.close();
		
	}
	
	public void addTeacher() {
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t = new Teacher();
		System.out.println("Enter teacher id");
		t.setTeacher_id(sc.nextInt());
		System.out.println("Enter teacher name");
		t.setTeacher_name(sc.next());
		
		for(int i=101;i<106;i++) {
			Department dept = em.find(Department.class, i);
			System.out.println(dept);
		}
		System.out.println();
		System.out.println("Enter dept id");
		Department dept = em.find(Department.class, sc.nextInt());
		t.setDepartment(dept);
		et.begin();
		
		em.persist(t);
		
		et.commit();
		
	}
	
	public void addCourse() {
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c = new Course();
		System.out.println("Enter course id");
		c.setCourse_id(sc.nextInt());
		System.out.println("Enter course name");
		c.setCourse_name(sc.next());
		System.out.println("Enter teacher id");
		Teacher t = em.find(Teacher.class, sc.nextInt());
		System.out.println(t.getTeacher_name());
		c.setTeacher(t);
		
		List<Student> student = new ArrayList<Student>();
		System.out.println("Enter number of students to register to this course");
		int n =sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter student id");
			Student st = em.find(Student.class, sc.nextInt());
			student.add(st);
		}
		c.setStudents(student);
		
		et.begin();
		
		em.persist(c);
		
		et.commit();
	}
	
	public void findStudentDetailsByName() {
		EntityManager em =emf.createEntityManager();
		System.out.println("Enter student roll number");
		Student s = em.find(Student.class, sc.nextInt());
		System.out.println("Student name--> "+s.getStu_name());
		System.out.println("Student mail--> "+s.getStu_email());
		System.out.println("Student department-> "+s.getDepartment());
	}
	
	public void removeStudentById() {
		EntityManager em =emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter student id");
		Student s = em.find(Student.class, sc.nextInt());
		System.out.println("Student to be removed is: "+s.getStu_name());
		
		em.remove(s);
	}
	
}
