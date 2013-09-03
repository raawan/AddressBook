package com.gumtree.addressbook.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtility implements ICalendarUtility {

	@Override
	public int ageDifferenceInDays(Date person1DOB, Date person2DOB) 
	{
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		if(person1DOB.after(person2DOB))
		{
			cal1.setTime(person2DOB);
			cal2.setTime(person1DOB);
		}
		else
		{
			cal1.setTime(person1DOB);
			cal2.setTime(person2DOB);
		}
		return daysBetween(cal1, cal2);
	}
	
	private int daysBetween(Calendar startDate, Calendar endDate) 
	{  
		Calendar date = (Calendar) startDate.clone();  
		int  daysBetween = 0;  
		while (date.before(endDate)) 
		{  
			date.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}  
		return daysBetween;  
	}
	
}
