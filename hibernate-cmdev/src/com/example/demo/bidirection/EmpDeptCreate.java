package com.example.demo.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department2;
import com.example.entity.Employee2;

/**
 * 
 * Emp,Dept : cascade = {CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH}
 *
 */
public class EmpDeptCreate {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee2.class)
								.addAnnotatedClass(Department2.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Employee2 emp1 = new Employee2(9110, "Alice", "alien", null, "2024-06-06", null, null);
			Employee2 emp2 = new Employee2(9111, "Amy", "alien", null, "2024-06-06", null, null);
			Employee2 emp3 = new Employee2(9112, "Annie", "alien", null, "2024-06-06", null, null);
			
			int deptno = 110;
			Department2 dept = session.get(Department2.class, deptno);

			emp1.setDepartment(dept);
			emp2.setDepartment(dept);
			emp3.setDepartment(dept);
			
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
	}
}
