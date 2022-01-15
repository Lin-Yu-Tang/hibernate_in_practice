package com.example.demo.bidirection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department2;
import com.example.entity.Employee2;

/**
 * OneToMany bidirectional access data
 * 可透過dept取得特定員工列表，也可以取得emp資料同時取得dept資料
 */
public class EmpDeptQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee2.class)
								.addAnnotatedClass(Department2.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// 給定deptno 取得dept與其對應的emp資料
			int deptId = 20;
			Department2 dept = session.get(Department2.class, deptId);
			System.out.println(dept);
			List<Employee2> empList = dept.getEmpList();
			empList.forEach(e -> System.out.println(e));
			
			// 給定empno 取得該emp資料與參照之dept資料
			int empId = 9003;
			Employee2 emp = session.get(Employee2.class, empId);
			System.out.println(emp);
			System.out.println(emp.getDepartment());
			
			
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			session.close();
			factory.close();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
	}

}
