package com.gumtree.addressbook.data;

import java.util.ArrayList;
import java.util.List;

public class AddressBook implements IData
{
	private final List<AddressBookEntry> addressBook = new ArrayList<AddressBookEntry>(); 

	public List<AddressBookEntry> getAddressBookEntry() 
	{
		return addressBook;
	}
}