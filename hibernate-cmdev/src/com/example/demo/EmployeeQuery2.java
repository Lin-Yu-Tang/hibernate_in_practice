package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import com.example.entity.Department;
import com.example.entity.Employee;

public class EmployeeQuery2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Department.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// native sql query
			// stored procedure
			
			// HQL
			List<Employee> list = 
				session.createQuery("from Employee order by salary DESC").getResultList();
			list.forEach(e -> System.out.println(e));
			
			
			// prepared statement
			Query queryEmp = session.createQuery("from Employee where empno = ?");
			queryEmp.setParameter(0, 2000);
			Employee theEmp = (Employee) queryEmp.getSingleResult();
			System.out.println(theEmp);
			
			// query by criteria
			System.out.println("================== QBC =================");
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.addOrder(Order.desc("salary")); // sort by salary in decending order
			List<Employee> list1 = criteria.list();
			list1.forEach(e->System.out.println(e));
			
			System.out.println("================== QBC prjection =================");
			Criteria c2 = session.createCriteria(Employee.class);
			c2.setProjection(Projections.projectionList()
					.add( Projections.property("id") )
					.add( Projections.property("ename"))
					.add( Projections.property("hiredate"))
					);
			List list2 = c2.list();
			Iterator it2 = list2.iterator();
			while(it2.hasNext()) {
				Object[] obj = (Object[]) it2.next();
				System.out.println("id: " + obj[0] +", name: " + obj[1] +", deptno: " + obj[2]);
			}
			
			System.out.println("================== QBC prjection group by =================");
			Criteria c3 = session.createCriteria(Employee.class);
			c3.setProjection(Projections.projectionList()
				.add( Projections.avg("salary") )
				.add( Projections.groupProperty("deptno") )
				);
			List list3 = c3.list();
			Iterator it3 = list3.iterator();
			System.out.println("avg_sal\t, deptno");
			while (it3.hasNext()) {
				Object[] obj = (Object[]) it3.next();
				System.out.println(obj[0] + "\t, " + obj[1]);
			}
			
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
