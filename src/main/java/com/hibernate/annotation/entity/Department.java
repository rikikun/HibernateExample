package com.hibernate.annotation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="DEPARTMENT")
@NamedQuery(name="dp.findAll",query="from Department")
public class Department {
	public Department() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employeelist;
	

	public List<Employee> getEmployeelist() {
		return employeelist;
	}


	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	
	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
