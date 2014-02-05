/**
 * 
 */
package com.sagi.controller;

import java.util.List;

import org.hibernate.Session;

import com.sagi.database.SessionDB;
import com.sagi.exception.ObjectExceptions;
import com.sagi.logic.Functions;

/**
 * @author Andres
 *
 */
public class FunctionController {

	@SuppressWarnings("unchecked")
	public static List<Functions> list(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Functions f order by f.functionId";
		return session.createQuery(hql).list();
	}
	
	/**
	 * can get a person by id
	 * @param id ID of person
	 * @return person found.  Null if not found
	 */
	public static Functions get(int id){
		Session sesion = SessionDB.getSession();
		return (Functions) sesion.get(Functions.class, id);
	}

	/**
	 * add any person at system
	 * @param person Person to add
	 * @throws ObjectExceptions If object is not valid
	 */
	public static void save(Functions function) throws ObjectExceptions{
		validate(function);
		Session sesion = SessionDB.getSession();
		sesion.save(function);
	}
	
	/**
	 * update lo que hace es actualizar un ingrediente
	 */
	public static void update(Functions function){
		Session session = SessionDB.getSession();
		session.update(function);
	}

	public void delete(Functions function){
		Session session = SessionDB.getSession();
		session.delete(function);
	}

	/**
	 * Can validate a object
	 * @param person Person to validate
	 * @throws ObjectExceptions If object is null
	 */
	private static void validate(Functions function) throws ObjectExceptions{
		if (function == null) {
			throw new ObjectExceptions("Object", "The function can't be null");
		}
	}   
	
}
