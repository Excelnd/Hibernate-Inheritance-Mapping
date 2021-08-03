package com.ihs2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihs2code.hibernate.entity.Instructor;
import com.ihs2code.hibernate.entity.Student;
import com.ihs2code.hibernate.entity.User;

public class CreateUserStudentInstructorDm {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the object	
			Student tempStudent  = new Student("John", "Doe", "john@ihs2code.com", "Hibernate");
			Instructor tempInstructor  = new Instructor("Ihs", "Public", "ihs@ihs2code.com", 20000.00);
		
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the students and Instructors ... ");
			session.save(tempStudent);
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
						
		}
		finally {
			// clean up code
			session.close();
			factory.close();
		}

	}

}
