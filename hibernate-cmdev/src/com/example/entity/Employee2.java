package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee2 {
	
	@Id
	@Column(name = "empno")
	private int empno;
	
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
	private Float comm;
	
	@ManyToOne(cascade = {CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "deptno")
	private Department2 department;
	
	public Employee2() {}

	public Employee2(int empno, String ename, String job, Integer manager, String hiredate, Float salary,
			Float comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
	}


	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
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

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Float getComm() {
		return comm;
	}

	public void setComm(Float comm) {
		this.comm = comm;
	}

	public Department2 getDepartment() {
		return department;
	}

	public void setDepartment(Department2 department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee2 [empno=" + empno + ", ename=" + ename + ", job=" + job + ", manager=" + manager
				+ ", hiredate=" + hiredate + ", salary=" + salary + ", comm=" + comm + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
