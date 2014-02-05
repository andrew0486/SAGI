package com.sagi.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sagi.controller.EmployeeController;
import com.sagi.controller.FunctionController;
import com.sagi.database.SessionDB;
import com.sagi.logic.Employees;
import com.sagi.logic.Functions;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.jsp")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Employees employee = null;
	private Functions function = null;
	private String error = "no se ha ingresado el error";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.isEmpty() || password.isEmpty()) {
			session.setAttribute("error", "Hay campos que se encuentran vacios");
		}else{
			this.employee = validateEmployee(userName, password);
			if (employee != null) {
				session.setAttribute("functionLogin", function);
				session.setAttribute("userId", employee.getEmployeeId());
				session.setAttribute("userName", employee.getFirstName());
				session.setAttribute("success", "El inicio de sesión ha sido exitoso");
				session.setAttribute("employeeLogin", employee);
				if (employee.getEmployeeId()==1) {
					session.setAttribute("administrator", "Has iniciado sesión como administrador del sistema");
				}
			}else{
				session.setAttribute("error", error);
				error = "no se ha ingresado el error";
			}
		}
		response.sendRedirect("index.jsp");
	}

	private Employees validateEmployee(String userName, String password){
		Employees emp = null;
		Employees employee = null;
		SessionDB.init();
		if (!EmployeeController.getEmployee(userName).isEmpty()) {
			emp = EmployeeController.getEmployee(userName).get(0);
			
			if (emp.getDocumentNumber().equals(userName)) {
				if ( password.equals(emp.getPassword())) {
					if ( emp.isActiveState() == true) {
						if (emp.getEndDate()==null) {
							employee = emp;		
							this.function = FunctionController.get(emp.getFunctions().getFunctionId());
						}else if (emp.getEndDate().after(new Date())) {
							employee = emp;
							this.function = FunctionController.get(emp.getFunctions().getFunctionId());
						}else if (emp.getEndDate().before(new Date())) {
							error = "El usuario con el que esta intentando acceder ya ha finalizado contrato";
							SessionDB.close();
						}					
					}else{
						error = "El Usuario se encuentra inactivo";
						SessionDB.close();
					}
				}else{
					error = "Usuario invalido, vuelve a intentarlo";
					SessionDB.close();
				}
			}else{
				error = "Usuario invalido, vuelve a intentarlo";
				SessionDB.close();
			}
		}else{
			error = "El usuario ingresado no existe";
			SessionDB.close();
		}
//		SessionDB.close();
		return employee;
	}
}
