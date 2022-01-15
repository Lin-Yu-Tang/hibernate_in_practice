package com.example.demo.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department2;
import com.example.entity.Employee2;

/**
 * 有問題
 */

public class EmpDeptDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee2.class)
								.addAnnotatedClass(Department2.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			/* 若員工對應的dept不存在，getDepartment()會發生null point exception */
			int empId = 9100;
			Employee2 emp = session.get(Employee2.class, empId);
			System.out.println(emp);
			Department2 department = emp.getDepartment();
			System.out.println(department);

			
			//?????
			session.delete(emp);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
	}

}
