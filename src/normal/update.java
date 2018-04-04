package normal;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkcompassdao;
import dao.homeworkdao;


public class update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int id = 0;
		String sid = req.getParameter("titleid");
		int titleid = Integer.parseInt(sid); 
		req.setAttribute("titleid", titleid);
		String title = req.getParameter("title");
		Date Date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		String textwork = req.getParameter("textwork");
		String Smark = req.getParameter("cmark");
		int cmark = Integer.parseInt(Smark);
		String picture =req.getParameter("picture");
		homework h = new homework(id,title, time, titleid, textwork,cmark,picture);
		homeworkdao dao = new homeworkdao();
			try {
				dao.update(h);
				homeworkcompassdao cdao = new homeworkcompassdao();
				cdao.updatehomework(h);
				
				RequestDispatcher rd=req.getRequestDispatcher("/xianshi2");
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

