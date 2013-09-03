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
	private final List<String> addressBook = new ArrayList<String>();
	private final AddressBookEntry firstAddressBookEntry = new AddressBookEntry();

	public List<String> getAddressBook() 
	{
		this.scanAddressBookFile();
		return addressBook;
	}

	public AddressBookEntry populateAddressBookEntries() 
	{
		this.scanAddressBookFile();
		String[] entries = addressBook.get(0).split(",");
		String[] name = entries[0].split(" "); 
		firstAddressBookEntry.setFirstName(name[0]);
		firstAddressBookEntry.setLastName(name[0]);
		firstAddressBookEntry.setSex(entries[1]);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try 
		{
			 date = formatter.parse(entries[2]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		firstAddressBookEntry.setDob(date);
		return firstAddressBookEntry;
	}


	private  final void scanAddressBookFile()
	{
		final File file;
		String fileLocation = "D:\\Workspace\\Gumtree\\AddressBook\\Resources\\AddressBook";

		file = new File(fileLocation);
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				addressBook.add(scanner.nextLine());
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
	}
}