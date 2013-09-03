package com.gumtree.addressbook.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.addressbook.service.AddressBookService;

public class TestAddressBookService {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTotalMalesInAddressBook_readAddressBookCSVFile_totalMalesInCSVFiles() 
	{
		int totalMales = new AddressBookService().totalMalesInAddressBook();
		assertEquals(3, totalMales);
	}

	@Test
	public void testOldestPersonInAddressBook_readAddressBookCSVFile_returnTheOldestPerson()
	{
		String oldestPersonName = new AddressBookService().oldestPersonInAddressBook();
		assertEquals("Wes Jackson", oldestPersonName);
	}

	@Test
	public void testTotalDaysDifferenceBetweenTwoPersonsAge_readTwoPersonsAge_ReturnTheAgeDiffInDays()
	{
		int diff = new AddressBookService().daysDifferenceBetweenTwoPersonsAge("Bill", "Paul");
		assertEquals( 2862, diff);
	}
}
