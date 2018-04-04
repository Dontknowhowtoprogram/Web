package score;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.scoredao;

import normal.score;




	public class updatescore extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			
			int id = 0;
			String ssid = req.getParameter("score");
			int score = Integer.parseInt(ssid); 
			String tid = req.getParameter("titleid");
			int titleid = Integer.parseInt(tid); 
			String username = req.getParameter("username");
			String xid = req.getParameter("textid");
			int textid = Integer.parseInt(xid); 

			
			score a = new score(id,score, titleid, username,textid);
			
			scoredao dao = new scoredao();
				try {
					dao.updatescore(a);
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

		

