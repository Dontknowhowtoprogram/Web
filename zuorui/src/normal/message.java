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


	public class message extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			String text = req.getParameter("text");
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String texttime = df.format(new Date());
			String username =req.getParameter("username");
			String sid = req.getParameter("titleid");
			int titleid = Integer.parseInt(sid); 
			int mark=0;
			comment c = new comment(0, text, texttime, username,titleid,mark);
			
			homeworkdao dao = new homeworkdao();
			
				try {
					int textid = dao.insertmessage(c);
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
