package com.gumtree.addressbook.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gumtree.addressbook.config.PropertiesConfiguration;

public class IOUtility implements IIOUtility {

	@Override
	public final List<String> scanAddressBookFile() 
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

}
