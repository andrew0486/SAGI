/**
 * 
 */
package com.sagi.controller;

import java.util.List;

import org.hibernate.Session;

import com.sagi.database.SessionDB;
import com.sagi.exception.ObjectExceptions;
import com.sagi.logic.Subdirectorates;

/**
 * @author Andres
 *
 */
public class SubdirectorateController {
	
	/**
	 * list of subdirectorates
	 * @return list of subdirectorates
	 */
	@SuppressWarnings("unchecked")
	public static List<Subdirectorates> list(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Subdirectorates s order by s.subdirectorateId";
		return session.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public static List<Subdirectorates> listOrder(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Subdirectorates s order by s.subdirectorateName";
		return session.createQuery(hql).list();
	}
	
	/**
	 * can get a subdirectorate by id
	 * @param id ID of subdirectorate
	 * @return Subdirectorates found.  Null if not found
	 */
	public static Subdirectorates get(int id){
		Session sesion = SessionDB.getSession();
		return (Subdirectorates) sesion.get(Subdirectorates.class, id);
	}

	/**
	 * add any person at system
	 * @param person Person to add
	 * @throws ObjectExceptions If object is not valid
	 */
	public void save(Subdirectorates subdirectorate) throws ObjectExceptions{
		validateSubdirectorate(subdirectorate);
		Session sesion = SessionDB.getSession();
		sesion.save(subdirectorate);
	}

	public void delete(Subdirectorates subdirectorate){
		Session session = SessionDB.getSession();
		session.delete(subdirectorate);
	}

	/**
	 * Can validate a object
	 * @param person Person to validate
	 * @throws ObjectExceptions If object is null
	 */
	private static void validateSubdirectorate(Subdirectorates subdirectorate) throws ObjectExceptions{
		if (subdirectorate == null) {
			throw new ObjectExceptions("Object", "The person can't be null");
		}
	}    


}
