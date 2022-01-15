package com.example.demo.bidirection2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department4;
import com.example.entity.Employee4;

/**
 * 更新dept
 * 取得特定dept的員工(dept.getEmpList().get()) 並更新資料
 */
public class EmpDeptUpdate {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee4.class)
								.addAnnotatedClass(Department4.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int deptno = 120;
			
			Department4 dept = session.get(Department4.class, deptno);
			
			// update dept
//			dept.setDname("NEWECO");
			
			
			// 直接更新PK會出事
//			dept.setDeptno(150);
			
			// 更新最後一位員工salary = 100;
			List<Employee4> empList = dept.getEmpList();
			Employee4 emp = empList.get(empList.size()-1);
			System.out.println(emp);
			emp.setSalary(new Float(100));
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
	}
}
