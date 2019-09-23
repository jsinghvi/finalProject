package com.infy.model;

public class ResultModel {
	private Integer personId;
	private Integer salary;
	private String desg;
	private String department;
	public Integer getPersonId() {
		return personId;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
