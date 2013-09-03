package com.gumtree.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook 
{
	private final List<String> addressBook = new ArrayList<String>();
	
	  public List<String> getAddressBook() 
	  {
		  this.scanAddressBookFile();
		  return addressBook;
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