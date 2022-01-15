package com.example.demo.unidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.SessionStatistics;

import com.example.entity.Department;
import com.example.entity.Employee3;

/**
 * 取得emp資料同時取得dept資料 (單向)
 */
public class EmpDeptQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee3.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			/* 取得特定員工 */
			int theId = 7369;
			// 方法1: get method
			Employee3 emp = session.get(Employee3.class, theId);
			System.out.println(emp);
			System.out.println(emp.getDepartment());
			// 方法2: createQuery
			List<Employee3> list = session.createQuery("from Employee3 where id = " + theId).getResultList();
			list.forEach(e -> System.out.println(e));
			
			
			SessionStatistics statistics = session.getStatistics();
			System.out.println(statistics);
			
			/* 取得特定部門 */
			int deptId = 20;
			Department department = session.get(Department.class, deptId);
			System.out.println("dept: " + department);
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
