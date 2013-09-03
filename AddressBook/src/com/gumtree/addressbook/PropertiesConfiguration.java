package com.gumtree.addressbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration 
{

	private Properties loadPropertiesConfigurationFile()
	{
		Properties prop = new Properties();
    	try 
    	{
    		prop.load(new FileInputStream
    				("D:\\Workspace\\Gumtree\\AddressBook\\Resources\\config.properties"));
    	} 
    	catch (IOException ex) 
    	{
    		ex.printStackTrace();
        }
		return prop;
	}
	
	public String getCSVAddressBookFileLocationProperty()
	{
		Properties prop = this.loadPropertiesConfigurationFile();
		return prop.getProperty("addressBookCSVFileLocation");
	}
}
