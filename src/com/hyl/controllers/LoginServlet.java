package com.hyl.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyl.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String pass = request.getParameter("password");
		String userName = request.getParameter("userName");
		if (new LoginServiceImpl().loginValidate(userName, pass)) {
			request.getSession(true);
			request.getSession().setAttribute("currentUser", userName);

		
			response.sendRedirect("ListMessageServlet");
		} else {
			response.getWriter().println("�û������������<br>");
			response.getWriter().println("<a href=\"index.jsp\">���ص�¼</a>");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
