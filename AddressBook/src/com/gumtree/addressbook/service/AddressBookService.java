package com.gumtree.addressbook.service;

import java.util.Collections;
import java.util.List;

import com.gumtree.addressbook.CalendarUtility;
import com.gumtree.addressbook.ICalendarUtility;
import com.gumtree.addressbook.dao.AddressBookDAOFactory;
import com.gumtree.addressbook.dao.IAddressBookDAO;
import com.gumtree.addressbook.data.AddressBookEntry;
import com.gumtree.addressbook.data.misc.AddressBookEntryComparatorByDOB;
import com.gumtree.addressbook.data.misc.ESex;
import com.gumtree.addressbook.exception.InvalidUserException;

public class AddressBookService implements IAddressBookService 
{
	private final IAddressBookDAO  addressBookDAO  = 
			AddressBookDAOFactory.getAddressBookDAOFactory().getAddressBookDAOInstance("file");

	@Override
	public int totalMalesInAddressBook() 
	{
		int totalMales = 0;
		for(AddressBookEntry addressEntry : addressBookDAO.getAddressBook().getAddressBookEntry())
		{
			if(addressEntry.getSex().equals(ESex.MALE))
				totalMales++;
		}
		return totalMales;
	}

	@Override
	public String oldestPersonInAddressBook() 
	{
		List<AddressBookEntry> entries = addressBookDAO.getAddressBook().getAddressBookEntry();
		Collections.sort(entries, new AddressBookEntryComparatorByDOB());
		return new StringBuilder().
				append(entries.get(0).getFirstName()).
				append(" ").
				append(entries.get(0).getLastName()).
				toString();
	}

	@Override
	public int daysDifferenceBetweenTwoPersonsAge(String person1FirstName,
			String person2FirstName) throws InvalidUserException 
	{
		AddressBookEntry person1 = addressBookDAO.getAddressBookEntryByFirstName(person1FirstName);
		AddressBookEntry person2 = addressBookDAO.getAddressBookEntryByFirstName(person2FirstName);
		
		ICalendarUtility calendarService = new CalendarUtility();
		return calendarService.ageDifferenceInDays(person1.getDob(),person2.getDob());
		
	}
	
}
