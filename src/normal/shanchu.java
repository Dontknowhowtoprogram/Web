package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkdao;


public class shanchu extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String sid = req.getParameter("textid");
		int textid = Integer.parseInt(sid); 
		String tid = req.getParameter("titleid");
		int titleid = Integer.parseInt(tid); 
		req.setAttribute("titleid", titleid);
		homeworkdao dao = new homeworkdao();
		try {
			dao.deletebyId(textid);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("/xianshi2");
		rd.forward(req, res);
}
}