package com.omisoft.jsp.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creating a servlet for the register page
 * @author bkoprinski
 *
 */
public class OnServletRegister extends HttpServlet {
	private Validator valid = new Validator();
	private static final long serialVersionUID = 1L;

	/**
	 * Overriding the get method
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		valid.register(req, resp);
	}

	/**
	 * Overriding the post method
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		valid.register(req, resp);
	}

	
}
