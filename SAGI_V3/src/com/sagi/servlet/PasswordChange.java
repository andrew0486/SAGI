package com.sagi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.sagi.controller.EmployeeController;
import com.sagi.database.SessionDB;
import com.sagi.logic.Employees;

/**
 * Servlet implementation class PasswordChange
 */
@WebServlet("/PasswordChange.jsp")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwordNow = request.getParameter("passwordNow");
		String passwordNew1 = request.getParameter("passwordNew");
		String passwordConfirm = request.getParameter("passwordConfirm");
		HttpSession session = request.getSession(true); 
		Object emp = session.getAttribute("employeeLogin");
		Employees employee = (Employees)emp;
		
		if (!passwordNow.equals(employee.getPassword())) {
			session.setAttribute("errorContrasena", "No se pudo realizar acción, vuelva a intentarlo nuevamente");
		}else{
			if (passwordNew1.equals(passwordConfirm)) {
				SessionDB.init();
				Employees employeeUpdate = EmployeeController.get(employee.getEmployeeId());
				employeeUpdate.setPassword(passwordNew1);
				EmployeeController.update(employeeUpdate);
				SessionDB.close();
				session.setAttribute("successContrasena", "Contraseña actualizada correctamente");
			}else{
				session.setAttribute("errorContrasena", "No se pudo realizar acción, vuelva a intentarlo nuevamente");
			}
		}
		response.sendRedirect("employee_information.jsp");
		
	}

}
