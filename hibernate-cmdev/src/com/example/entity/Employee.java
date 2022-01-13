package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 沒有使用@ManyToOne
 */

@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@Column(name = "empno")
	private int id;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "manager")
	private Integer manager;
	
	@Column(name = "hiredate")
	private String hiredate;
	
	@Column(name = "salary")
	private Float salary;
	
	@Column(name = "comm")
	private Float commission;
	
//	@ManyToOne()
//	@JoinColumn(name = "deptno")
//	private Department department;
	
	@Column(name = "deptno")
	private Integer deptno;
	
	

	public Employee(int id, 
			String ename, 
			String job, 
			Integer manager, 
			String hiredate, 
			Float salary, Float commission,
			Integer deptno) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.commission = commission;
		this.deptno = deptno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", job=" + job + ", manager=" + manager + ", hiredate="
				+ hiredate + ", salary=" + salary + ", commission=" + commission + ", deptno=" + deptno + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
