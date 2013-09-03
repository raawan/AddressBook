package com.gumtree.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddressBook 
{
	private final List<AddressBookEntry> addressBook = new ArrayList<AddressBookEntry>(); 

	public List<AddressBookEntry> getAddressBookEntry() 
	{
		return addressBook;
	}

	public List<AddressBookEntry> populateAddressBookEntries() 
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
			addressBookEntry.setSex(entries[1]);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			Date date = null;
			try 
			{
				date = formatter.parse(entries[2]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			addressBookEntry.setDob(date);
			addressBook.add(addressBookEntry);
		}

		return addressBook;
	}

	private  final List<String> scanAddressBookFile()
	{
		final File file;
		final List<String> addressBookCSV = new ArrayList<String>();
		//ToDo: put location in properties file
		String fileLocation = "D:\\Workspace\\TestEgit\\TestAddressBook\\Resources\\AddressBook";

		file = new File(fileLocation);
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
			ex.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		return addressBookCSV;
	}

}