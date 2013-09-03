package com.gumtree.addressbook.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.addressbook.ESex;
import com.gumtree.addressbook.dao.AddressBookDAOFactory;
import com.gumtree.addressbook.dao.IAddressBookDAO;

public class TestAddressBookDAO 
{
	private IAddressBookDAO addressBook;
	
	@Before
	public void setUp() throws Exception 
	{
		addressBook = AddressBookDAOFactory.getAddressBookDAOFactory().getAddressBookDAOInstance("file");
	}

	@After
	public void tearDown() throws Exception 
	{
		addressBook = null;
	}

		/*
		 * Test Name Format
		 * MethodName_Scenario_ExpectedOutput
		 */
	
	@Test
	public void createAddressBookEntry_getFirstNameOfFirstEntry_firstNameOFFirstEntry()
	{
		String expectedOutput = "Bill";
		String actual =   addressBook.getAddressBook().getAddressBookEntry().get(0).getFirstName();
		assertEquals(expectedOutput,actual);
	}
	
	@Test
	public void createAddressBookEntry_getFirstNameOfSecondEntry_firstNameOfSecondEntry()
	{
		String expectedOutput = "Paul";
		String actual =   addressBook.getAddressBook().getAddressBookEntry().get(1).getFirstName();
		assertEquals(expectedOutput,actual);
	}
	
	@Test
	public void createAddressBookEntry_getSexOfFirstEntry_Male()
	{
		ESex expectedOutput = ESex.MALE;
		ESex actual =   addressBook.getAddressBook().getAddressBookEntry().get(0).getSex();
		assertEquals(expectedOutput,actual);
	}
}
