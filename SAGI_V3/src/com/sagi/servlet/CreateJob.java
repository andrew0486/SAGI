package com.sagi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sagi.logic.Jobs;

/**
 * Servlet implementation class CreateJob
 */
@WebServlet("/create_job.jsp")
public class CreateJob extends HttpServlet {
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
		HttpSession session = request.getSession(true);
		Object list = session.getAttribute("listJob");
		List<Jobs> listJob = (List<Jobs>)list;
		String job = request.getParameter("newJob"); 
		for (Jobs jobs : listJob) {
			System.out.println(jobs.getJobTitle());
			if ((jobs.getJobTitle().toUpperCase()).contains(job.toUpperCase())) {
				System.out.println("ya contiene este objeto");
				break;
			}else{
				System.out.println("El nuevo trabajo es : "+ job);
			}
		}
		response.sendRedirect("employees_edit.jsp");
	}

}
