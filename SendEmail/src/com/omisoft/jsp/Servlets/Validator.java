package com.omisoft.jsp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omisoft.jsp.DAO.AddToTableDAO;
import com.omisoft.jsp.DTO.GetTableInfoDTO;

/**
 * This class keeps all the methods which are executed in the Servlet classes
 * @author bkoprinski
 *
 */
public class Validator extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private HttpSession session;

	/**
	 * Login method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void validate(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
        res.setContentType("text/html");
      
        	
        String email=req.getParameter("email");
        String pass=req.getParameter("userPassword");
        
        AddToTableDAO obj = new AddToTableDAO();
		
        if (obj.checkUser(email, pass)) 
        {
        	try
    		{
        		session = req.getSession(true); 
        		session.setAttribute("aaaa", email);
    		}
        	catch(NullPointerException e)
        	{
        		e.printStackTrace();
        	}
    		res.sendRedirect("EmailForm.html");
    		
        }
        else
        {
        	res.sendRedirect("LoginFail.jsp");
        }
        
	}
	
	/**
	 * Register method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void register(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        
        AddToTableDAO addUser = new AddToTableDAO();
        
        String fistname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email= req.getParameter("email");
        String pass = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        
        if(!addUser.checkEmail(email))
        {
        	GetTableInfoDTO userInfo = new GetTableInfoDTO(fistname,lastname,email,pass,age);
            
            addUser.addToTable(userInfo);
            res.sendRedirect("Success.jsp");
        }
        else
        {
        	pw.println("Email exists!");
        }
        
        if(pw != null)
        {
        	pw.close();
        }
	}
	
	/**
	 * Send email method
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	public void send(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String to = req.getParameter("to");
		String subject = req.getParameter("subject");
		String message = req.getParameter("textBody");
//		String path = "/home/GitHub";
//		String attachPath = req.getParameter("choose"); // Problema e 4e ne vzemam pravliniq put!!!
		String attachPath = "/home/bkoprinski/HOT ROX UK ORDER";
		System.out.println(attachPath);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465"); // SSL port from Oracle documentation!
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("b.koprinski@omisoft.eu","aaaaa");
					}
				}		
		);
		
		try
		{
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress("b.koprinski@omisoft.eu"));
			mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			mess.setSubject(subject);
//			mess.setText(message); zasega samo tova komentiram
			
			
			BodyPart messaBodyPart = new javax.mail.internet.MimeBodyPart();
			messaBodyPart.setText(message);
			Multipart multipart = new javax.mail.internet.MimeMultipart();
			multipart.addBodyPart(messaBodyPart);
			
			
			messaBodyPart = new javax.mail.internet.MimeBodyPart();
			DataSource source = new FileDataSource(attachPath);
			messaBodyPart.setDataHandler(new DataHandler(source));
			multipart.addBodyPart(messaBodyPart);
			mess.setContent(multipart);
		
			
			
			javax.mail.Transport.send(mess);
			
			System.out.println("Message send!");
			pw.println("Thank you for choosing Omisoft.");
			pw.println("Your message has been send successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Message not send!");
			pw.println("Message not send!");
		}
		finally
		{
			if(pw != null)
			{
				pw.close();
			}
		}
		
	}
	
}
