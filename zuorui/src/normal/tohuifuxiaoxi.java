package normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkdao;

public class tohuifuxiaoxi extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sid = req.getParameter("huifuid");	
		int huifuid = Integer.parseInt(sid);
		homeworkdao dao = new homeworkdao();
		homeworkdao dao1 = new homeworkdao();
			
				huifu f;
				try {	f = dao1.updatexiaoxi(huifuid);
				req.setAttribute("f", f);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
				
					f = dao.sousuohuifubyid(huifuid);
					req.setAttribute("f", f);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    req.getRequestDispatcher("/huifuxiaoxi.jsp").forward(req, res);
			}
}
