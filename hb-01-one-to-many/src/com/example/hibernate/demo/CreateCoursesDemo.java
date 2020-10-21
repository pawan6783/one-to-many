package com.example.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			Course tempCourse1 = new Course("data science");
			Course tempCourse2 = new Course("IOT");
			
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, id);
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
