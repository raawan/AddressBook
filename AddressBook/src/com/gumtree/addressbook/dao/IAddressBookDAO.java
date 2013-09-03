package com.gumtree.addressbook.dao;

import com.gumtree.addressbook.data.AddressBook;
import com.gumtree.addressbook.data.AddressBookEntry;

public interface IAddressBookDAO 
{
	public AddressBook getAddressBook() ;
	public AddressBookEntry getAddressBookEntryByFirstName(String firstName);
}
