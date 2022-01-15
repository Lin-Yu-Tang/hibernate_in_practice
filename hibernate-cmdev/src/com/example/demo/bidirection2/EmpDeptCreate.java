package com.example.demo.bidirection2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 創建dept資料同時創建emp資料
 */
public class EmpDeptCreate {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee4.class)
								.addAnnotatedClass(Department4.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Department4 dept = new Department4(120, "eco", "Taipei");
			
			List<Employee4> list = new ArrayList<Employee4>();
			
			Employee4 emp1 = new Employee4(1001, "Lily", "student", null, "2000-07-01", null, null);
			Employee4 emp2 = new Employee4(1002, "Ken", "student", null, "2000-07-01", null, null);
			Employee4 emp3 = new Employee4(1003, "Jason", "student", null, "2000-07-01", null, null);
			emp1.setDepartment4(dept);
			emp2.setDepartment4(dept);
			emp3.setDepartment4(dept);
			list.add(emp1); 
			list.add(emp2); list.add(emp3);
			dept.setEmpList(list);
			
			session.save(dept);
			
//			session.save(emp1);
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
	}
}
