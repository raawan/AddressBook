package com.gumtree.addressbook.dao;

import java.util.List;

import com.gumtree.addressbook.data.AddressBook;
import com.gumtree.addressbook.data.AddressBookEntry;
import com.gumtree.addressbook.data.misc.ESex;
import com.gumtree.addressbook.exception.InvalidUserException;
import com.gumtree.addressbook.utility.DateUtility;
import com.gumtree.addressbook.utility.IOUtility;

public class AddressBookFileDAO implements IAddressBookDAO 
{

	private final AddressBook addressBook = new AddressBook();

	@Override
	public AddressBook getAddressBook() 
	{
		this.populateAddressBookEntries();
		return addressBook;
	}
	
	@Override
	public AddressBookEntry getAddressBookEntryByFirstName(String firstName) 
				throws InvalidUserException 
	{
		this.populateAddressBookEntries();
		for(AddressBookEntry entry : addressBook.getAddressBookEntry())
		{
			if(entry.getFirstName().equalsIgnoreCase(firstName.trim()))
				return entry;
		}
		throw new InvalidUserException();
	}

	
	private void  populateAddressBookEntries() 
	{
		final List<String> addressBookCSV = new IOUtility().scanAddressBookFile();
		AddressBookEntry addressBookEntry = null;

		for(String addressBookCSVEntry: addressBookCSV)
		{
			addressBookEntry = new AddressBookEntry();
			String[] entries = addressBookCSVEntry.split(",");
			String[] name = entries[0].split(" "); 
			addressBookEntry.setFirstName(name[0]);
			addressBookEntry.setLastName(name[1]);
			addressBookEntry.setSex(setSex(entries[1]));
			addressBookEntry.setDob(new DateUtility().formatDate((entries[2])));
			addressBook.getAddressBookEntry().add(addressBookEntry);
		}
	}

	private ESex setSex(String textSex)
	{
		String  obj = textSex.trim();
		if(obj.equalsIgnoreCase("Male"))
		{
			return ESex.MALE;
		}
		else if (obj.equalsIgnoreCase("Female"))
		{
			return ESex.FEMALE;
		}
		return ESex.OTHER;
	}

}
