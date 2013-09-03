package com.gumtree.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook 
{
	private final List<AddressBookEntry> addressBook = new ArrayList<AddressBookEntry>(); 

	public List<AddressBookEntry> getAddressBookEntry() 
	{
		return addressBook;
	}
}