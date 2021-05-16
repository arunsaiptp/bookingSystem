package com.hotelBookingSystem.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author DevangamS
 *
 */
public class DateUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
   
	private static DateUtil instance = null;

	private DateUtil() {
	}

	public static DateUtil getInstance() {
		if (null == instance) {
			instance = new DateUtil();
		}
		return instance;
	}

	/**
	 * 
	 * @param pdateString
	 * @return
	 */
	public Timestamp convertStringToTimestamp(String strTime) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
			Date parsedDate = dateFormat.parse(strTime);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
			System.out.println(timestamp);
		} catch (Exception e) { // this generic but you can control another types of exception
			// look the origin of excption
		}
		return timestamp;
	}

}
