package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkdao;



public class tomessage extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sid = req.getParameter("titleid");	
		int titleid = Integer.parseInt(sid);
		homeworkdao dao = new homeworkdao();
			try {
				homework c;
				c = dao.queryById(titleid);
				req.setAttribute("c", c);
			    req.getRequestDispatcher("/message.jsp").forward(req, res);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}
}