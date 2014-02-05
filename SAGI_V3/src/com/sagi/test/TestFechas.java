package com.sagi.test;

import java.text.DateFormat;
import java.util.Date;

import com.sagi.exception.ObjectExceptions;

public class TestFechas {

	public static void main(String[] args) {
//		System.out.println(ObjectExceptions.changeDate("2013-12-15").getYear());
		Date fecha = new Date(2013, 12, 20);
		System.out.println(fecha.equals(new Date()));
	}

}
