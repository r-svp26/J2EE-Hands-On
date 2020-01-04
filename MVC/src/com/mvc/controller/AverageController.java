package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.AverageCalculator;

@WebServlet("/AverageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int x = Integer.parseInt(req.getParameter("num1"));
		int y = Integer.parseInt(req.getParameter("num2"));

		AverageCalculator model = new AverageCalculator();
		int result = model.calculate(x, y);
		req.setAttribute("result", result);

		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		rd.forward(req, resp);
	}

}
