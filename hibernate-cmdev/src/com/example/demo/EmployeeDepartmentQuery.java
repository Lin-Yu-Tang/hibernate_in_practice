package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department;
import com.example.entity.Employee;

/**
 * 不使用外鍵參照，分別取得emp或dept
 */
public class EmployeeDepartmentQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Employee> employee = session.createQuery("from Employee").getResultList();
			
			employee.forEach(e -> System.out.println(e));
			
			
			int empno = 9000;
			Employee theEmp = session.get(Employee.class, empno);
			
			System.out.println("empno(" + 9000 + ") employee: " + theEmp);
			
			
			int deptno = 80;
			Department department = session.get(Department.class, deptno);
			System.out.println("deptno(" + deptno + ") department: " + department);
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
	}

}
