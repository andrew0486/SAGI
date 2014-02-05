package com.sagi.database;

import org.hibernate.Session;

public class SessionDB {

	private static Session session;
	
	/**
	 * Init session DB. Load any mapping 
	 */
	public static void init(){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

	}
	
	/**
	 * Close session DB 
	 */
	public static void close(){
		session.close();
	}
	
	/**
	 * Confirm any change
	 */
	public static void commit(){
		session.getTransaction().commit();
	}
	
	public static Session getSession() {
		return session;
	}
}