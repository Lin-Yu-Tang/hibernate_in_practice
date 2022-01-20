package com.example.demo.bidirection2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

public class EmpDeptQuery {
	
	public static void main(String[] args) {
		
		SessionFactory  factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee4.class)
									.addAnnotatedClass(Department4.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Employee4> list = session.createQuery("from Employee4").getResultList();
			
			
			list.forEach(e->System.out.println(e));
			
			
			
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
		
	}
}
