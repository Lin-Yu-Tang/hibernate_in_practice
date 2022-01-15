package com.example.demo.bidirection2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 在特定部門新增員工
 */
public class EmpDeptCreate2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee4.class)
								.addAnnotatedClass(Department4.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int deptno = 110;
			Department4 dept = session.get(Department4.class, deptno);
			List<Employee4> empList = dept.getEmpList();
			
			empList.forEach(e -> System.out.println(e));
			
			Employee4 emp = new Employee4(9102, "Claire", "alien", null, "2024-01-01", null, null);
			
			// insert into emp
			empList.add(emp);
			
			empList.forEach(e -> System.out.println(e));
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
