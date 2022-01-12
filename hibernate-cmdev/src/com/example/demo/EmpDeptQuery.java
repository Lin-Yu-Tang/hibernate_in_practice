package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department;
import com.example.entity.Emp;

public class EmpDeptQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Emp.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 7369;
			Emp emp = session.get(Emp.class, theId);
			
			System.out.println("get method");
			System.out.println(emp);
			System.out.println(emp.getDepartment());
			
			
			List<Emp> list = session.createQuery("from Emp where id = " + theId).getResultList();
			list.forEach(e -> System.out.println(e));
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
