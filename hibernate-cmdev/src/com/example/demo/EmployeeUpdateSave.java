package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Employee;

public class EmployeeUpdateSave {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Employee employee = new Employee(9005,
											"Ella",
											"newbie",
											90,
											"2020-01-01",
											new Float(1000),
											new Float(0),
											new Integer(110));
			// 若PK 重複，則更新該員工資料
			session.saveOrUpdate(employee);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
	}

}
