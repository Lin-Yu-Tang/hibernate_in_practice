package com.example.demo.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department2;
import com.example.entity.Employee2;

public class EmpDeptSave {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee2.class)
								.addAnnotatedClass(Department2.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
//			Employee2 emp = 
//					new Employee2(8080, "Tomcat", "container", null, 
//							"1999-01-01", new Float(0), new Float(0));
//			
//			Department2 dept = new Department2(70, "apache", "USA");
//			
//			emp.setDepartment(dept);
//			
//			session.saveOrUpdate(emp);
//			session.saveOrUpdate(dept);
			
			Employee2 emp2 = new Employee2(9200,"Bill","alien", null,
									"2024-01-01",null,null);
			Department2 dept2 = new Department2(120, "mount", "Moon");
			
			emp2.setDepartment(dept2);
			
//			session.save(emp2);
//			session.save(dept2);
			
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
