/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sagi.test;


import java.util.List;

import com.sagi.controller.EmployeeController;
import com.sagi.controller.JobController;
import com.sagi.controller.SubdirectorateController;
import com.sagi.database.SessionDB;
import com.sagi.logic.Employees;
import com.sagi.logic.Jobs;
import com.sagi.logic.Subdirectorates;

/**
 *
 * @author Andres
 */
public class testEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionDB.init();
//		List<Employees> list = EmployeeController.list();
//		for (Employees employee : list) {
//			System.out.println(employee.getEmployeeId()+ " - "+employee.getFirstName()+ " " + employee.getLastName());
//			System.out.println(employee.getDocumentType() + " - " + employee.getDocumentCity());
//		}
//		
//		if (!EmployeeController.getEmployee("123405100").isEmpty()) {
//			List<Employees> em = EmployeeController.getEmployee("123405100");
//			System.out.println(em.get(0).getDocumentNumber()+ " "+ em.get(0).getPassword());
//		}else{
//			System.out.println("No se encontro nada");
//		}
		
//		List<Employees> emp = EmployeeController.list();
//		for (Employees employees : emp) {
//			System.out.println(employees.getSubdirectorates().getSubdirectorateId());
//			System.out.println(employees.getSubdirectorates().getSubdirectorateName());
//		}
		
//		List<Employees> listOrder = EmployeeController.listOrder();
//		for (Employees e: listOrder) {
//			System.out.println("Empleados "+ e.getLastName()+ " " + e.getFirstName());
//		}
		
//		List<Jobs> listOrderJ = JobController.listOrder();
//		for (Jobs j: listOrderJ) {
//			System.out.println("trabajos "+ j.getJobTitle());
//		}
//		
//		List<Subdirectorates> listOrderS = SubdirectorateController.listOrder();
//		for (Subdirectorates s: listOrderS) {
//			System.out.println("subdireccion "+ s.getSubdirectorateName());
//		}
		List<Employees> lista = EmployeeController.listBySubdirectorate(2);
		for (Employees employees : lista) {
			System.out.println(employees.getLastName()+ " "+ employees.getFirstName() + " - " + employees.getSubdirectorates().getSubdirectorateName());
		}
		SessionDB.close();
		

	}

}
