package com.gumtree.addressbook;

import java.util.Comparator;

import com.gumtree.addressbook.data.AddressBookEntry;

public class AddressBookEntryComparatorByDOB implements Comparator<AddressBookEntry> {

	@Override
	public int compare(AddressBookEntry arg0, AddressBookEntry arg1) 
	{
		return arg0.getDob().compareTo(arg1.getDob());
	}

}
