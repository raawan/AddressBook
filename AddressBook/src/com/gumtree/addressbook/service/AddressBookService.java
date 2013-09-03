package com.gumtree.addressbook.service;

import com.gumtree.addressbook.ESex;
import com.gumtree.addressbook.dao.AddressBookDAOFactory;
import com.gumtree.addressbook.dao.IAddressBookDAO;
import com.gumtree.addressbook.data.AddressBookEntry;

public class AddressBookService implements IAddressBookService 
{
	private final IAddressBookDAO  addressBook  = 
			        AddressBookDAOFactory.getAddressBookDAOFactory().getAddressBookDAOInstance("file");
	
	@Override
	public int totalMalesInAddressBook() 
	{
		int totalMales = 0;
		for(AddressBookEntry addressEntry : addressBook.getAddressBook().getAddressBookEntry())
		{
			if(addressEntry.getSex().equals(ESex.MALE))
				totalMales++;
		}
		return totalMales;
	}

	@Override
	public String oldestPersonInAddressBook() 
	{
		return null;
	}

}
