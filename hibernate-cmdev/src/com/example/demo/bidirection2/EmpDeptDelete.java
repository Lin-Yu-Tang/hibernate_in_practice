package com.example.demo.bidirection2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 1. 刪除員工資料
 * 2. 刪除部門及相關員工資料
 */
public class EmpDeptDelete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee4.class)
									.addAnnotatedClass(Department4.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			
			// delete specific employee
			/* if referenced department not exist, throw org.hibernate.ObjectNotFoundException */
//			int empno = 1002;
//			Employee4 emp = session.get(Employee4.class, empno);
//			System.out.println(emp);
//			session.delete(emp);
			
			
			
			// delete specific department and related employees
//			int deptno = 120;
//			Department4 dept = session.get(Department4.class, deptno);
//			System.out.println(dept);
//			System.out.println(dept.getEmpList());
//			session.delete(dept);
			
			
			int empId = 9100;
			Employee4 emp = session.get(Employee4.class, empId);
			session.delete(emp);
			
			
			
			
			
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
