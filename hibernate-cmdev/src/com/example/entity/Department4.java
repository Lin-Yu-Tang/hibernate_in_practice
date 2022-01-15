package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department4 {

	@Id
	@Column(name = "deptno")
	private int deptno;
	
	@Column(name = "dname")
	private String dname;
	
	@Column(name = "location")
	private String location;
	
//	@OneToMany(mappedBy = "department",
//			cascade = {CascadeType.DETACH, CascadeType.MERGE, 
//					CascadeType.PERSIST}) // 關閉同步更新
	@OneToMany(mappedBy = "department",
			cascade = CascadeType.ALL)
	private List<Employee4> empList;
	
	public Department4() {}

	public Department4(int deptno, String dname, String location) {
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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

	public List<Employee4> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee4> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Department2 [deptno=" + deptno + ", dname=" + dname + ", location=" + location + "]";
	}
	
	
	
}
