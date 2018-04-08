package normal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;

public class zhuce extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
	{
		res.setCharacterEncoding("UTF-8");
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username1 = req.getParameter("username");
		userdao dao = new userdao();
		user u = null;
		try {
			u = dao.queryByuser(username1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

		
		if (u==null){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String type = new String("1");
		String sex = req.getParameter("sex");
		String grade = req.getParameter("grade");
		String idd=req.getParameter("identification");
		int identification = Integer.parseInt(idd); 
		user w = new user(0, username, password, type, sex, grade,identification,0);
		
		try {
			dao.insertuser(w);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			res.sendRedirect("/zuorui/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(u!=null){
			try {
				res.sendRedirect("/zuorui/fregist.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}	





