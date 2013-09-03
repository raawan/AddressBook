package com.gumtree.addressbook.service;

import com.gumtree.addressbook.exception.InvalidUserException;

public interface IAddressBookService 
{
	public int totalMalesInAddressBook();
	public String oldestPersonInAddressBook();
	public int daysDifferenceBetweenTwoPersonsAge
				(String person1FirstName, String person2FirstName)
						throws InvalidUserException ;
}
