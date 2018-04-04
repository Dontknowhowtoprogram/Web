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

import normal.comment;
import normal.score;




	public class intscore extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
		 
			String ssid = req.getParameter("score");
			int score = Integer.parseInt(ssid); 
			String tid = req.getParameter("titleid");
			int titleid = Integer.parseInt(tid); 
			String username = req.getParameter("username");
			String xid = req.getParameter("textid");
			int textid = Integer.parseInt(xid); 
			int mark=1;
			String text=null;
			String texttime=null;
			score a = new score(0,score, titleid, username,textid);
			
			scoredao dao = new scoredao();
				try {
					int id = dao.insertscore(a);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comment c=new comment(textid,text, texttime,  username, titleid, mark);
				try {
					dao.updatemark(c);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = req.getRequestDispatcher("/xianshi2");
				rd.forward(req, res);
			}
		}

		

