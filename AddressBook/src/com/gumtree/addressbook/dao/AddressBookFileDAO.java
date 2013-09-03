package com.gumtree.addressbook.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.gumtree.addressbook.ESex;
import com.gumtree.addressbook.PropertiesConfiguration;
import com.gumtree.addressbook.data.AddressBook;
import com.gumtree.addressbook.data.AddressBookEntry;
import com.gumtree.addressbook.exception.InvalidUserException;

public class AddressBookFileDAO implements IAddressBookDAO 
{

	private final AddressBook addressBook = new AddressBook();

	@Override
	public AddressBook getAddressBook() 
	{
		this.populateAddressBookEntries();
		return addressBook;
	}

	private void  populateAddressBookEntries() 
	{
		final List<String> addressBookCSV = this.scanAddressBookFile();
		AddressBookEntry addressBookEntry = null;

		for(String addressBookCSVEntry: addressBookCSV)
		{
			addressBookEntry = new AddressBookEntry();
			String[] entries = addressBookCSVEntry.split(",");
			String[] name = entries[0].split(" "); 
			addressBookEntry.setFirstName(name[0]);
			addressBookEntry.setLastName(name[1]);
			addressBookEntry.setSex(setSex(entries[1]));
			addressBookEntry.setDob(formatDate(entries[2]));
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

	private Date formatDate(String textDob)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try 
		{
			date = formatter.parse(textDob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private  final List<String> scanAddressBookFile()
	{
		final File file;
		final List<String> addressBookCSV = new ArrayList<String>();
		
		file = new File(new PropertiesConfiguration().getCSVAddressBookFileLocationProperty());
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				addressBookCSV.add(scanner.nextLine());
			}
		}
		catch(final FileNotFoundException ex)
		{
			//ToDO: Handle Error logic
			ex.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		return addressBookCSV;
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


}
