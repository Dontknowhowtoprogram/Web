package normal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.senddao;

public class xiaoxi extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String username = req.getParameter("username");	
		senddao dao = new senddao();
		List<huifu> list;
		try {
			list= dao.xiaoxi(username);
			req.setAttribute("list",list);
			RequestDispatcher rd=req.getRequestDispatcher("/xiaoxi.jsp");
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

	