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
import javax.servlet.http.HttpSession;

import dao.homeworkdao;
import dao.senddao;


	public class sendmail extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			String username = req.getParameter("username");
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			String title =req.getParameter("title");
			String textwork =req.getParameter("textwork");
			String name =req.getParameter("name");
			int mark = 0;
			String sid =req.getParameter("titleid");
			int titleid = Integer.parseInt(sid);
			mail c = new mail(0, username,title,textwork,name,mark,time,titleid);
			
			senddao dao = new senddao();
			
				try {
					int mailid = dao.insertmail(c);
					RequestDispatcher rd = req.getRequestDispatcher("/xianshi");
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
