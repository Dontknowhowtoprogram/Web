package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import normal.user;
import dao.homeworkdao;
import dao.userdao;
import java.sql.Date;
import java.text.SimpleDateFormat;

import dao.userdao;

public class login extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user u = null;
		
		userdao dao = new userdao();
		userdao dao1 = new userdao();
		try {
			u = dao.queryByuser(username);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			
			
		if (u==null){
			res.sendRedirect("/zuorui/flogin.jsp");}
		else if(u!=null){
		if(password.equals(u.getPassword())){
				
				HttpSession session = req.getSession();
				session.setAttribute("username",username);
				String type = u.getType();
				HttpSession sessions = req.getSession();
				sessions.setAttribute("type",type);
				req.setAttribute("u", u);
				RequestDispatcher rd = req.getRequestDispatcher("xianshi");
				try {
					u = dao1.updatelogin(username);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		
				else{try {
					res.sendRedirect("/zuorui/flogin.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			
		}
			}
		
	}

			