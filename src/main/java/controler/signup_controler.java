package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.signupdao;
import dto.signup_dto;
@WebServlet("/signup")
public class signup_controler extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String name=req.getParameter("name");
		String emailid=req.getParameter("emailid");
		String pwd=req.getParameter("pwd");
		int pwd1=Integer.parseInt(pwd);
		
		signup_dto sd=new signup_dto();
		sd.setEmail(emailid);
		sd.setName(name);
		sd.setPwd(pwd1);
		
		 signupdao d1=new  signupdao();
		d1.signup(sd);
	}
	
	

}
