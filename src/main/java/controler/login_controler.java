package controler;

import java.io.IOException;
import java.net.http.HttpClient.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.signupdao;
import dto.signup_dto;
@WebServlet("/login")
public class login_controler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		String email=req.getParameter("emailid");
		String pwd=req.getParameter("pwd");
		int password=Integer.parseInt(pwd);
		
           signupdao d1=new signupdao();
		 signup_dto sd=d1.login(email);
		 if(sd !=null) {
			 if(sd.getPwd()==password) {
				 resp.getWriter().print(" <h1>welcome to web page</h1>");
				 resp.sendRedirect("https://www.facebook.com/login/");
			 }else {
				 resp.getWriter().print("<h1>enter proper password</h1>");
				 RequestDispatcher rd=req.getRequestDispatcher("login.html");
				 rd.include(req, resp);
			 }}
		 else {
			 resp.getWriter().print("<h1>account not found,please signup</h1><a href='signup.html'>click here to sign up</a>");
			 
			 }
		 }
		 
	}
	


