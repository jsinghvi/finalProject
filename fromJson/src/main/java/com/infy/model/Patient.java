package com.infy.model;

public class Patient {
private int personId;
private String firstName;
private String lastName;
private String address;
private long[] phoneNo;
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long[] getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long[] phoneNo) {
	this.phoneNo = phoneNo;
}
@Override
public String toString() {
	System.out.println("Printing Producer"+this.address+""+this.phoneNo+""+this.lastName);
    return ""+personId + ","
            + firstName + ","
            + lastName + ","
            + address + "";
}
}
