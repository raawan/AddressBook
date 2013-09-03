package com.gumtree.addressbook.dao;

public class AddressBookDAOFactory 
{
	private static AddressBookDAOFactory factory;

	private AddressBookDAOFactory()
	{
	}

	public static synchronized AddressBookDAOFactory getAddressBookDAOFactory()
	{
		if(factory == null)
		{
			factory = new AddressBookDAOFactory();
		}
		return factory;
	}

	public IAddressBookDAO getAddressBookDAOInstance(String type)
	{
		IAddressBookDAO addressBookDAO = null;
		if(type.equalsIgnoreCase("file"))
		{
			return new AddressBookFileDAO();
		}
		return addressBookDAO;
	}
}
