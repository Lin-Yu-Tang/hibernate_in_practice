package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.SessionStatistics;

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
			
			/* 取得特定員工 */
			int theId = 7369;
			// 方法1: get method
			Emp emp = session.get(Emp.class, theId);
			System.out.println(emp);
			System.out.println(emp.getDepartment());
			// 方法2: createQuery
			List<Emp> list = session.createQuery("from Emp where id = " + theId).getResultList();
			list.forEach(e -> System.out.println(e));
			
			
			SessionStatistics statistics = session.getStatistics();
			
			System.out.println(statistics);
			
			int entityCount = statistics.getEntityCount();
			System.out.println("stat");
			System.out.println("entityCount: " + entityCount);
			
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
