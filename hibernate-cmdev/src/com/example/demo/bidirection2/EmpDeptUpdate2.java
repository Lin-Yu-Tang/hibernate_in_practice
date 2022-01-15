package com.example.demo.bidirection2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 由empno取得特定emp，並更新該dept資料
 */
public class EmpDeptUpdate2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee4.class)
				.addAnnotatedClass(Department4.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int empno = 8080;
			Employee4 emp = session.get(Employee4.class, empno);
			Department4 dept = emp.getDepartment4();
			
			dept.setDname("APACHE");
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
