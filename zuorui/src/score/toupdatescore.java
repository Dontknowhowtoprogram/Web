package score;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import normal.comment;
import normal.score;
import dao.scoredao;

public class toupdatescore extends HttpServlet{
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			String sid = req.getParameter("textid");	
			int textid = Integer.parseInt(sid);
			scoredao dao = new scoredao();
				try {
					comment c;
					c = dao.chengji(textid);
					req.setAttribute("c", c);
				   
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				score x;
				try {
					x=dao.fenshu(textid);
					req.setAttribute("x", x);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 req.getRequestDispatcher("/updatescore.jsp").forward(req, res);
	}
	}
