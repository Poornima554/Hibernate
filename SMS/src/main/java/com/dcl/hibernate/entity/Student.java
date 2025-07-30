package com.dcl.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	private int stu_id;
	private String stu_name;

	private String stu_email;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> course;

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_email() {
		return stu_email;
	}

	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Course> getCourse() {
		return course;
	}
//	@Override
//	public String toString() {
//		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_email=" + stu_email + ", department="
//				+ department + ", course=" + course + "]";
//	}
	
}
