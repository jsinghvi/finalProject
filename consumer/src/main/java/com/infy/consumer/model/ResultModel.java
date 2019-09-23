package com.infy.consumer.model;

public class ResultModel {
	private Integer personId;
	private Integer salary;
	private String desg;
	private String department;
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
//		this.personId = personId;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
