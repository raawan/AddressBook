package com.gumtree.addressbook.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.addressbook.exception.InvalidUserException;
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
	public void testTotalDaysDifferenceBetweenTwoPersonsAge_readTwoPersonsAge_ReturnTheAgeDiffInDays_1()
			throws InvalidUserException 
	{
		int diff = new AddressBookService().daysDifferenceBetweenTwoPersonsAge("Bill", "Paul");
		assertEquals( 2862, diff);
	}
	
	@Test
	public void testTotalDaysDifferenceBetweenTwoPersonsAge_readTwoPersonsAge_ReturnTheAgeDiffInDays_2()
			throws InvalidUserException 
	{
		int diff = new AddressBookService().daysDifferenceBetweenTwoPersonsAge( "Paul","Bill");
		assertEquals( 2862, diff);
	}
	
	@Test(expected=InvalidUserException.class)
	public void testTotalDaysDifferenceBetweenTwoPersonsAge_InvalidUserName_ThrowsInvalidUserNameException()
			throws InvalidUserException 
	{
		int diff = new AddressBookService().daysDifferenceBetweenTwoPersonsAge( "qwerty","Bill");
		assertEquals( 2862, diff);
	}
}
