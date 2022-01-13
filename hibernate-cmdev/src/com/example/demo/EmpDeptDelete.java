package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department;
import com.example.entity.Emp;

public class EmpDeptDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Emp.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 9005;
			Emp emp = session.get(Emp.class, theId);
			System.out.println(emp);
			/* 若entity有關聯table的entity 其值為null 執行刪除，會發生exception */
			
			// 刪除9004 emp，同時刪除該部門 需使用CascadeType.REMOVE
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
