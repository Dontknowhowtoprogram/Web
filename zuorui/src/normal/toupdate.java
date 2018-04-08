package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkdao;

public class toupdate extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sid = req.getParameter("titleid");
		int titleid = Integer.parseInt(sid);
		homeworkdao dao = new homeworkdao();
		try {
			homework h = dao.queryById(titleid);
			req.setAttribute("h", h);
			req.getRequestDispatcher("/update.jsp").forward(req, res);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
 }
}