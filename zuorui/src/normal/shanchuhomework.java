package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.homeworkcompassdao;
import dao.homeworkdao;


public class shanchuhomework extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String sid = req.getParameter("titleid");
		int titleid = Integer.parseInt(sid); 
		String username = req.getParameter("username");	
		req.setAttribute("username", username);
		homeworkdao dao = new homeworkdao();
		try {
			dao.deletehomeworkId(titleid);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		homeworkcompassdao cdao = new homeworkcompassdao();
		cdao.deletehomework(titleid);
		RequestDispatcher rd=req.getRequestDispatcher("/xianshi");
		rd.forward(req, res);
}
}