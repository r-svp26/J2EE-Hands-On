package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(req.getParameter("num1")!=null && req.getParameter("num2")!=null){
		
		int x= Integer.parseInt(req.getParameter("num1"));
		int y= Integer.parseInt(req.getParameter("num1"));
		
		PrintWriter out = resp.getWriter();
		out.println("Ths Sum Is:"+(x+y));
		}
		
	}

}
