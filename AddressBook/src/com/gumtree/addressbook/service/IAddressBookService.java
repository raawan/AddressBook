package com.gumtree.addressbook.service;

public interface IAddressBookService 
{
	public int totalMalesInAddressBook();
	public String oldestPersonInAddressBook();
	public int daysDifferenceBetweenTwoPersonsAge
				(String person1FirstName, String person2FirstName);
}
