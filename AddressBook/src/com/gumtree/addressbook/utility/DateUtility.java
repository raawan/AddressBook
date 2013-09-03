package com.gumtree.addressbook.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility implements IDateUtility 
{
	@Override
	public Date formatDate(String textDob) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try 
		{
			date = formatter.parse(textDob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
