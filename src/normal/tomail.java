package normal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.senddao;
import dao.userdao;

public class tomail extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sid = req.getParameter("titleid");	
		int titleid = Integer.parseInt(sid);
		senddao dao=new senddao();
		homework m;
		userdao dao1=new userdao();
		List<user> list ;
		
		
		try {
			list=dao1.getalluser();
			req.setAttribute("list",list);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			m=dao.mailById(titleid);
			req.setAttribute("m", m);
			RequestDispatcher rd=req.getRequestDispatcher("/mail.jsp");
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
