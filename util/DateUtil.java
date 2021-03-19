package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date dateObj = null;
		try {
			dateObj = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return dateObj;
	}

}
