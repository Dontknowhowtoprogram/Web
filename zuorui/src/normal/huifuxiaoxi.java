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

import dao.homeworkdao;


	public class huifuxiaoxi extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			String username = req.getParameter("username");
			String sid = req.getParameter("textid");
			int textid = Integer.parseInt(sid); 
			String name = req.getParameter("name");
			String intext =req.getParameter("intext");
			int mark = 0;
			String lid = req.getParameter("titleid");
			int titleid = Integer.parseInt(lid); 
			Date date = new Date();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
			String nowtime = df.format(new Date());
			
			
			
			
			huifu c = new huifu(username,textid, name, intext, 0,nowtime,mark,titleid);
			
			homeworkdao dao = new homeworkdao();
			
				try {
					int huifuid = dao.huifuxiaoxi(c);
					RequestDispatcher rd = req.getRequestDispatcher("/xianshi2");
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
