package com.gumtree.addressbook.service;

public class AddressBookServiceFactory 
{
	private static IAddressBookService factory;
	
	private AddressBookServiceFactory(){}
	
	public static  IAddressBookService getInstance()
	{
		synchronized(AddressBookServiceFactory.class)
		{
			if(factory == null)
			{
				factory = new AddressBookService();
			}
			return factory;
		}
	}
}
