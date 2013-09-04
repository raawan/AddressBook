package com.gumtree.addressbook.restapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gumtree.addressbook.service.AddressBookServiceFactory;
import com.gumtree.addressbook.service.IAddressBookService;

@Controller()
@RequestMapping(value="/api/v1/addressBook")
public class AddressBookController implements IGenericController 
{
	private final IAddressBookService addressBookService 
							= AddressBookServiceFactory.getInstance();
	
	@RequestMapping(method = RequestMethod.GET)
	public  @ResponseBody String help(HttpServletRequest request, 
								HttpServletResponse response)
	{
		return "1:/api/v1/addressBook/total_males" + "\n" + "2:/api/v1/addressBook/oldest_person";
	}
	
	@RequestMapping(value="total_males",method = RequestMethod.GET)
	public  @ResponseBody Integer totalMalesInAddressBook(HttpServletRequest request, 
								HttpServletResponse response)
	{
		return addressBookService.totalMalesInAddressBook();
	}
	
	@RequestMapping(value="oldest_person",method = RequestMethod.GET)
	public  @ResponseBody String oldestPersonInAddressBook(HttpServletRequest request, 
								HttpServletResponse response)
	{
		return addressBookService.oldestPersonInAddressBook();
	}
}
