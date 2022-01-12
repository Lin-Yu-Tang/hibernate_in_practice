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

@Entity
@Table(name = "emp")
public class Emp {
	
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
	
	@ManyToOne()
	@JoinColumn(name = "deptno")
	private Department department;
	
	public Emp() {}

	public Emp(int id, String ename, String job, Integer manager, String hiredate, Float salary, Float commission) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.commission = commission;
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

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", job=" + job + ", manager=" + manager + ", hiredate=" + hiredate
				+ ", salary=" + salary + ", commission=" + commission + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
