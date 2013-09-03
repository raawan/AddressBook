package com.gumtree.addressbook.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.addressbook.AddressBook;

public class TestAddressBook {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	  * Test Name Format
	   * MethodName_Scenario_ExpectedOutput
	   */
	
	@Test
	public void createAddressBookEntry_getFirstNameOfFirstEntry_firstNameOFFirstEntry()
	{
		String expectedOutput = "Bill";
		String actual =  new AddressBook().populateAddressBookEntries().get(0).getFirstName();
		assertEquals(expectedOutput,actual);
	}
	
	@Test
	public void createAddressBookEntry_getFirstNameOfSecondEntry_firstNameOfSecondEntry()
	{
		String expectedOutput = "Paul";
		String actual =  new AddressBook().populateAddressBookEntries().get(1).getFirstName();
		assertEquals(expectedOutput,actual);
	}
}
