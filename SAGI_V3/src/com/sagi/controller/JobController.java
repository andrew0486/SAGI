/**
 * 
 */
package com.sagi.controller;

import java.util.List;

import org.hibernate.Session;

import com.sagi.database.SessionDB;
import com.sagi.exception.ObjectExceptions;
import com.sagi.logic.Jobs;

/**
 * @author Andres
 *
 */
public class JobController {


	/**
	 * list of jobs title
	 * @return list jobs
	 */
	@SuppressWarnings("unchecked")
	public static List<Jobs> list(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Jobs s order by s.jobId";
		return session.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public static List<Jobs> listOrder(){
		Session session = SessionDB.getSession();
		String hql = "from com.sagi.logic.Jobs s order by s.jobTitle";
		return session.createQuery(hql).list();
	}

	/**
	 * can get a job by id
	 * @param id ID of job
	 * @return job found.  Null if not found
	 */
	public static Jobs get(int id){
		Session sesion = SessionDB.getSession();
		return (Jobs) sesion.get(Jobs.class, id);
	}

	/**
	 * add any job at system
	 * @param job Job to add
	 * @throws ObjectExceptions If object is not valid
	 */
	public void save(Jobs job) throws ObjectExceptions{
		validateJob(job);
		Session sesion = SessionDB.getSession();
		sesion.save(job);
	}

	public void delete(Jobs job){
		Session session = SessionDB.getSession();
		session.delete(job);
	}

	/**
	 * Can validate a object
	 * @param person Person to validate
	 * @throws ObjectExceptions If object is null
	 */
	private static void validateJob(Jobs job) throws ObjectExceptions{
		if (job == null) {
			throw new ObjectExceptions("Object", "The person can't be null");
		}
	}    

}
