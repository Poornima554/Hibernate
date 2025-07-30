package com.dcl.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int dept_id;
	private String dept_name;
	
	@OneToMany(mappedBy = "department")
	List<Student> student;
	
	@OneToMany(mappedBy = "department")
	List<Teacher> teacher;

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Student> getStudent() {
		return student;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", student=" + student + ", teacher="
				+ teacher + "]";
	}

	
	
}
