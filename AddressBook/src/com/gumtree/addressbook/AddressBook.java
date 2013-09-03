package com.gumtree.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook 
{
	private final List<String> addressBook = new ArrayList<String>();
	
	  public List<String> getAddressBook() 
	  {
		  addressBook.add("Bill McKnight, Male, 16/03/77");
	    return addressBook;
	  }
}