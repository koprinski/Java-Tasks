package com.omisoft.jsp.Servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creating a servlet for the login page
 * @author bkoprinski
 *
 */
public class OnServletLogin extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
	private Validator valid = new Validator();
	
	/**
	 * Overriding the get method
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		valid.validate(req, resp);
	}

	/**
	 * Overriding the post method
	 */
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		valid.validate(req, res);
    }
 
}