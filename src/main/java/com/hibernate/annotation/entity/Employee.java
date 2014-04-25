package com.hibernate.annotation.entity;

import java.util.Date;







import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name="aa.findAll",query="from Employee ep WHERE ep.id=:ID")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Integer id;
	
	@ManyToOne (cascade = javax.persistence.CascadeType.REMOVE)
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;
	
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDateTime;
	
	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, Integer salary,
			Integer age, String phoneNumber, Integer sex, String position,
			Date birthday, String email, String address,Department dpid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.position = position;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.department=dpid;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "AGE")
	private int age;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "SEX")
	private int sex;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "BIRTH_DATE")
	private Date birthday;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ADDRESS")
	private String address;

}
