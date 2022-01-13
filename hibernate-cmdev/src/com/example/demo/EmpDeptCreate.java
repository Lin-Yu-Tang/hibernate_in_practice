package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department;
import com.example.entity.Emp;

public class EmpDeptCreate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Emp.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Emp emp = 
			new Emp(9005, "Ella", "freashman", 7902, "2020-01-01", new Float(1000), new Float(0));
			Department department = new Department(120, "Newbie", "France");
			emp.setDepartment(department);
			
			// 如果Emp的屬性Department 沒有使用cascade
//			session.save(emp);
//			session.save(department);
			
			// Emp 使用cascade.all 存入emp同步存入dept
			session.save(emp);
			
			session.getTransaction().commit();
			
			System.out.println("done!!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
	}

}
