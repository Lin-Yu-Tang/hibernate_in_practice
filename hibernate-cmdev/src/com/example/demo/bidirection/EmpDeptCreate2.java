package com.example.demo.bidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department2;
import com.example.entity.Employee2;

/**
 * Emp,Dept : cascade = {CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH}
 * 無法透過dept getEmpList() 和session.update(dept) 去新增emp 資料
 */
public class EmpDeptCreate2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee2.class)
								.addAnnotatedClass(Department2.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			

			Employee2 emp1 = new Employee2(9113, "Alice", "alien", null, "2024-06-06", null, null);
			Employee2 emp2 = new Employee2(9114, "Amy", "alien", null, "2024-06-06", null, null);
			Employee2 emp3 = new Employee2(9115, "Annie", "alien", null, "2024-06-06", null, null);
			
			int deptno = 110;
			Department2 dept = session.get(Department2.class, deptno);

			emp1.setDepartment(dept);
			emp2.setDepartment(dept);
			emp3.setDepartment(dept);
			
			List<Employee2> list = dept.getEmpList();
			list.add(emp1); list.add(emp2); list.add(emp3);
			
			
			
			session.update(dept);
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
