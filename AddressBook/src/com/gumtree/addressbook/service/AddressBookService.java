package com.gumtree.addressbook.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import com.gumtree.addressbook.AddressBookEntryComparatorByDOB;
import com.gumtree.addressbook.ESex;
import com.gumtree.addressbook.dao.AddressBookDAOFactory;
import com.gumtree.addressbook.dao.IAddressBookDAO;
import com.gumtree.addressbook.data.AddressBookEntry;

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
			String person2FirstName) 
	{
		AddressBookEntry person1 = addressBookDAO.getAddressBookEntryByFirstName(person1FirstName);
		AddressBookEntry person2 = addressBookDAO.getAddressBookEntryByFirstName(person2FirstName);

		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		cal1.setTime(person1.getDob());
		cal2.setTime(person2.getDob());
		return daysBetween(cal1, cal2);
	}

	private int daysBetween(Calendar startDate, Calendar endDate) 
	{  
		Calendar date = (Calendar) startDate.clone();  
		int  daysBetween = 0;  
		while (date.before(endDate)) 
		{  
			date.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}  
		return daysBetween;  
	}

}
