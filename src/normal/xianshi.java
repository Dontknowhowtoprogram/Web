package normal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.homeworkdao;



public class xianshi extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		homeworkdao dao = new homeworkdao();
		String username = req.getParameter("username");	
		if(username==null){
			username = (String) req.getAttribute("username");
		}


		String name = req.getParameter("name");	
		List<homework> list ;
		List<comment> list1;
		List<huifu> list2;
		List<score>list3;
	
			try {
				list= dao.getAllPersons();
				req.setAttribute("list",list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				list1= dao.xianshicomment();
				req.setAttribute("list1",list1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				list2=dao.huifuuser();
				req.setAttribute("list2", list2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				list3=dao.xianshisocre();
				req.setAttribute("list3", list3);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count;
			try {
				if(name!=null){
					count = dao.count(name);
				}else{
					count = dao.count(username);
				}
				
				req.setAttribute("count", count);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int countm;
			try {
				if(name!=null){
					countm = dao.countm(name);
				}else{
					countm = dao.countm(username);
				}
				
				req.setAttribute("countm", countm);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher rd=req.getRequestDispatcher("/main.jsp");
			rd.forward(req, res);
			
		}
	}

