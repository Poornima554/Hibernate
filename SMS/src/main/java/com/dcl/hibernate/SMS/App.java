package com.dcl.hibernate.SMS;

import java.util.Scanner;

import com.dcl.hibernate.dao.SMS_Dao;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	SMS_Dao st = new SMS_Dao();
    	System.out.println("1. Add student");
    	System.out.println("2. Add Teacher");
    	System.out.println("3. Add Course");
    	System.out.println("4. Find Student");
    	System.out.println("5. Remove student");
    	System.out.println("Enter your choice");
    	int ch = sc.nextInt();
    	
//    	st.findStudentDetailsByName();
    	
    	switch(ch) {
    	case 1: st.addStudent();
    	break;
    	
    	case 2: st.addTeacher();
    	break;
    	
    	case 3: st.addCourse();
    	break;
    	
    	case 4: st.findStudentDetailsByName();
    	break;
    	
    	case 5: st.removeStudentById();
    	break;
    	
    	}
    }
}
