package com.sagi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sagi.controller.EmployeeController;
import com.sagi.controller.FunctionController;
import com.sagi.controller.JobController;
import com.sagi.controller.SubdirectorateController;
import com.sagi.database.SessionDB;
import com.sagi.exception.ObjectExceptions;
import com.sagi.logic.Employees;
import com.sagi.logic.Functions;

/**
 * Servlet implementation class EmployeeSave
 */
@WebServlet("/EmployeeSave.jsp" )
public class EmployeeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//do nothing
		response.sendRedirect("employees_edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName").toUpperCase();
		String lastName = request.getParameter("lastName").toUpperCase();
		String streetAddress = request.getParameter("streetAddress").toUpperCase();
		String cityResident = request.getParameter("cityResident").toUpperCase();
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String documentType = request.getParameter("documentType");
		String documentCity = request.getParameter("documentCity").toUpperCase();
		String documentNumber = request.getParameter("documentNumber");
		boolean createUser = selectFuntion(request.getParameter("createUser"));
		boolean uploadUser = selectFuntion(request.getParameter("uploadUser"));
		boolean deleteUser = selectFuntion(request.getParameter("deleteUser"));
		boolean createFile = selectFuntion(request.getParameter("createFile"));
		boolean uploadFile = selectFuntion(request.getParameter("uploadFile"));
		boolean deleteFile = selectFuntion(request.getParameter("deleteFile"));
		boolean createProcess = selectFuntion(request.getParameter("createProcess"));
		boolean uploadProcess = selectFuntion(request.getParameter("uploadProcess"));
		boolean deleteProcess = selectFuntion(request.getParameter("deleteProcess"));
		boolean createAutoStart = selectFuntion(request.getParameter("createAutoStart"));
		boolean uploadAutoStart = selectFuntion(request.getParameter("uploadAutoStart"));
		boolean deleteAutoStart = selectFuntion(request.getParameter("deleteAutoStart"));
		boolean createAutoRequeriment = selectFuntion(request.getParameter("createAutoRequeriment"));
		boolean uploadAutoRequeriment = selectFuntion(request.getParameter("uploadAutorequeriment"));
		boolean deleteAutoRequeriment = selectFuntion(request.getParameter("deleteAutoRequeriment"));
		boolean createNotice = selectFuntion(request.getParameter("createNotice"));
		boolean uploadNotice = selectFuntion(request.getParameter("uploadNotice"));
		boolean deleteNotice = selectFuntion(request.getParameter("deleteNotice"));
		boolean createTechnicalConcept = selectFuntion(request.getParameter("createTechnicalConcept"));
		boolean uploadTechnicalConcept = selectFuntion(request.getParameter("uploadTechnicalConcept"));
		boolean deleteTechnicalConcept = selectFuntion(request.getParameter("deleteTechnicalConcept"));
		boolean createResolution = selectFuntion(request.getParameter("createResolution"));
		boolean uploadResolution = selectFuntion(request.getParameter("uploadResolution"));
		boolean deleteResolution = selectFuntion(request.getParameter("deleteResolution"));
		int subdirectorate = Integer.parseInt(request.getParameter("subdirectorate"));
		String manager = request.getParameter("manager");
		String hireDate = request.getParameter("hireDate");
		String endDate = request.getParameter("endDate");
		int job = Integer.parseInt(request.getParameter("job"));
		String activeState = request.getParameter("activeState");

		HttpSession session = request.getSession(true);
		
		Object employeeUpdate = session.getAttribute("employeeUpdate1");
		if (employeeUpdate ==null){
			System.out.println("sesion nula desde el employeesave");
		}

//		SessionDB.init();
		List<Employees> listaEmp = EmployeeController.list();
		int funtionId = FunctionController.list().size()+1;

		Functions function = null;
		Employees employee = null;
		if (employeeUpdate == null) {
			function = new Functions(createUser, uploadUser, deleteUser, createFile, uploadFile, 
					deleteFile, createProcess, uploadProcess, deleteProcess, createAutoStart, 
					uploadAutoStart, deleteAutoStart, createAutoRequeriment, uploadAutoRequeriment, 
					deleteAutoRequeriment, createNotice, uploadNotice, deleteNotice, createTechnicalConcept, 
					uploadTechnicalConcept, deleteTechnicalConcept, createResolution, uploadResolution, deleteResolution);
			function.setFunctionId(funtionId);
			employee = new Employees(firstName, lastName, streetAddress, cityResident, 
					phoneNumber, email, documentType, documentCity, documentNumber);
		}else{			
			//employee = EmployeeController.get(Integer.parseInt(employeeUpdate.toString()));
			employee = EmployeeController.get(Integer.parseInt(employeeUpdate.toString()));
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setStreetAddress(streetAddress);
			employee.setCity(cityResident);
			employee.setPhoneNumber(phoneNumber);
			employee.setEmail(email);
			employee.setDocumentType(documentType);
			employee.setDocumentCity(documentCity);
			employee.setDocumentNumber(documentNumber);
			
			if (employee.getFunctions()!=null) {
				function = FunctionController.get(employee.getFunctions().getFunctionId());
				function.setCreateAutoRequeriment(createAutoRequeriment);
				function.setCreateAutoStart(createAutoStart);
				function.setCreateFile(createFile);
				function.setCreateNotice(createNotice);
				function.setCreateProcess(createProcess);
				function.setCreateResolution(createResolution);
				function.setCreateTechnicalConcept(createTechnicalConcept);
				function.setCreateUser(createUser);
				function.setUploadAutoRequeriment(uploadAutoRequeriment);
				function.setUploadAutoStart(uploadAutoStart);
				function.setUploadFile(uploadFile);
				function.setUploadNotice(uploadNotice);
				function.setUploadProcess(uploadProcess);
				function.setUploadResolution(uploadResolution);
				function.setUploadTechnicalConcept(uploadTechnicalConcept);
				function.setUploadUser(uploadUser);
				function.setDeleteAutoRequeriment(deleteAutoRequeriment);
				function.setDeleteAutoStart(deleteAutoStart);
				function.setDeleteFile(deleteFile);
				function.setDeleteNotice(deleteNotice);
				function.setDeleteProcess(deleteProcess);
				function.setDeleteResolution(deleteResolution);
				function.setDeleteTechnicalConcept(deleteTechnicalConcept);
				function.setDeleteUser(deleteUser);
				
			}
		}
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date hireDate2 = null;
		try {
			hireDate2 = formatoDelTexto.parse(hireDate);
			employee.setHireDate(hireDate2);
			if (endDate!="") {
				Date endDate2 = null;
				endDate2 = formatoDelTexto.parse(endDate);
				if (hireDate2.before(endDate2)) {
					employee.setEndDate(endDate2);
				}
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		employee.asigneActiveState(activeState);


		for (int i = 0; i < listaEmp.size(); i++) {
			employee.getEmployeeses().add(listaEmp.get(i));
		}

		if (!manager.equals("vacio")) {
			employee.setEmployees(EmployeeController.get(Integer.parseInt(manager)));
		}
		employee.setSubdirectorates(SubdirectorateController.get(subdirectorate));
		employee.setJobs(JobController.get(job));
		employee.setFunctions(function);
		try {
			if (employeeUpdate==null) {
				if (employee.equalsEmployee(documentNumber)==false) {			
					employee.setEmployeeId(listaEmp.size()+1);
					FunctionController.save(function);
					EmployeeController.save(employee);
					
					function.setEmployees(employee);
					FunctionController.update(function);
				}
			}else{
				FunctionController.update(function);
				EmployeeController.update(employee);
				session.removeAttribute("employeeUpdate1");
			}

			response.sendRedirect("employeeList.jsp");
		} catch (ObjectExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("_modal.html");
		}
//		SessionDB.close();

	}
	
	public boolean selectFuntion(String function){
		boolean func = false;
		if (function != null) {
			func = true;
		}
		return func;
	}

}
