package com.gumtree.addressbook.data;

import java.util.Date;

import com.gumtree.addressbook.ESex;

public class AddressBookEntry implements IData
{
	private String firstName;
	private String lastName;
	private ESex sex;
	private Date dob;

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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public ESex getSex() {
		return sex;
	}
	public void setSex(ESex sex) {
		this.sex = sex;
	}
}
