package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Employee;

public class EmployeeQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Employee> employee = session.createQuery("from Employee").getResultList();
			
			employee.forEach(e -> System.out.println(e));
			
			
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
	}

}
