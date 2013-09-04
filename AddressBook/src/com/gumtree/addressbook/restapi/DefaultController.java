package com.gumtree.addressbook.restapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping(value="/")
public class DefaultController implements IGenericController 
{
	@RequestMapping(method = RequestMethod.GET)
	public  @ResponseBody String getMyDetails(HttpServletRequest request, 
								HttpServletResponse response)
	{
		return "ADDRESSBOOK RESTAPI";
	}
}
