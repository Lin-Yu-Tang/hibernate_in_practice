package com.example.demo.bidirection2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

public class EmpDeptRead {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee4.class)
									.addAnnotatedClass(Department4.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			// get emp -> dept
			int empno = 1003;
			Employee4 emp = session.get(Employee4.class, empno);
			System.out.println(emp);
			System.out.println(emp.getDepartment4());
			
			// get dept -> emp
			int deptno = 20;
			Department4 dept20 = session.get(Department4.class, deptno);
			System.out.println(dept20);
			List<Employee4> empList20 = dept20.getEmpList();
			empList20.forEach(e -> System.out.println(e));
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
