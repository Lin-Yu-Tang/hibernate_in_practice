package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	
	@Id
	@Column(name = "deptno")
	private int deptno;
	
	@Column(name = "dname")
	private String dname;
	
	@Column(name = "location")
	private String location;
	
	public Department() {}

	
	public Department(int deptno, String dname, String location) {
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", location=" + location + "]";
	}
	
	
	
	
}
