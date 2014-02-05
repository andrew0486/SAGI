/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagi.controller;

import java.util.List;

import org.hibernate.Session;

import com.sagi.database.SessionDB;
import com.sagi.exception.ObjectExceptions;
import com.sagi.logic.Employees;
import com.sagi.logic.Subdirectorates;

/**
 *
 * @author Andres
 */
public class EmployeeController {

	@SuppressWarnings("unchecked")
	public static List<Employees> list(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Employees p order by p.employeeId";
		return session.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public static List<Employees> getEmployee(String documentNumber){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Employees e where e.documentNumber like '"+ documentNumber+"'";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Employees> listBySubdirectorate(int idSubdirectorate){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Employees e where e.subdirectorates.subdirectorateId like '"+ idSubdirectorate+"' order by e.lastName, e.firstName";
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Employees> listOrder(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Employees p order by p.lastName, p.firstName";
		return session.createQuery(hql).list();
	}
	
	/**
	 * can get a person by id
	 * @param id ID of person
	 * @return person found.  Null if not found
	 */
	public static Employees get(int id){
		Session sesion = SessionDB.getSession();
		return (Employees) sesion.get(Employees.class, id);
	}

	/**
	 * add any person at system
	 * @param person Person to add
	 * @throws ObjectExceptions If object is not valid
	 */
	public static void save(Employees employee) throws ObjectExceptions{
		validate(employee);
		Session sesion = SessionDB.getSession();
		sesion.save(employee);
		SessionDB.commit();
	}
	
	/**
	 * update lo que hace es actualizar un ingrediente
	 */
	public static void update(Employees employee){
		Session session = SessionDB.getSession();
		session.update(employee);
		SessionDB.commit();
	}

	public void delete(Employees employee){
		Session session = SessionDB.getSession();
		session.delete(employee);
	}

	/**
	 * Can validate a object
	 * @param person Person to validate
	 * @throws ObjectExceptions If object is null
	 */
	private static void validate(Employees employee) throws ObjectExceptions{
		if (employee == null) {
			throw new ObjectExceptions("Object", "The person can't be null");
		}
	}    

}
