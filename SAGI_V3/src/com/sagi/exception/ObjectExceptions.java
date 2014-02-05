package com.sagi.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import sun.org.mozilla.javascript.internal.regexp.SubString;

/**
 * exception in logic objects
 * @author andres huertas
 *
 */
public class ObjectExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 * @param field Field to error
	 * @param message Message generate
	 */
	public ObjectExceptions(String field, String message){
		super(field + " " + message);
	}
	
	public static final Date changeDate(String date){
		int year = Integer.parseInt(date.substring(0, 3));
		int month = Integer.parseInt(date.substring(5, 6));
		int day = Integer.parseInt(date.substring(8, 9));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		fecha.setMonth(month);
		fecha.setYear(year);
		fecha.setDate(day);
		return fecha;
	}
}
