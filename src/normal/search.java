package normal;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkcompassdao;


public class search extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		homeworkcompassdao dao = new homeworkcompassdao();
		List<homework>list;
		String search=req.getParameter("search");
		list= dao.queryBykeywords(search);
		req.setAttribute("list",list);
		RequestDispatcher rd=req.getRequestDispatcher("/main.jsp");
		rd.forward(req, res);

	}
}
