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

	@Override
	public boolean equals(Object arg0) 
	{
		if(arg0==null)
		{
			return false;
		}
		if(this==arg0)
		{
			return true;
		}
		if(!(arg0 instanceof AddressBookEntry))
		{
			return false;
		}
		AddressBookEntry user = (AddressBookEntry)arg0;
		if(	user.getFirstName().equals(this.getFirstName()) &&
				user.getLastName().equals(this.getLastName()) &&
				user.getSex().equals(this.getSex()) &&
				user.getDob().equals(this.getDob()))
		{
			return true;
		}
		return super.equals(arg0);
	}

	@Override
	public int hashCode() 
	{
		final int prime = 37;
		int result = 1;
		result = result * prime + this.getFirstName().hashCode();
		result = result * prime + this.getLastName().hashCode();
		result = result * prime + this.getSex().hashCode();
		result = result * prime + this.getDob().hashCode();
		return result;
	}

}
