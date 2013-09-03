package com.gumtree.addressbook.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAddressBookDAO.class, TestAddressBookService.class })
public class AllTests {

}
