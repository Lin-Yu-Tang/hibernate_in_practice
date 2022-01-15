package com.example.demo.bidirection2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 由emp使用setDepartment()新增dept 失敗範例 
 */
public class EmpDeptCreate3 {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee4.class)
									.addAnnotatedClass(Department4.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			// 只會存入emp資料
			Department4 dept = new Department4(200, "NETWORK", "Taiwan");
			Employee4 emp = new Employee4(2000, "Kidd", "COACH", null, "1999-01-01", new Float(50000), null);
			emp.setDepartment4(dept);
			session.save(emp);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
