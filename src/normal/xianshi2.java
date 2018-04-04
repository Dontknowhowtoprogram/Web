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
import dao.senddao;



public class xianshi2 extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		senddao dao = new senddao();
		homeworkdao dao1 = new homeworkdao();
		String tid = req.getParameter("titleid");
		int titleid = Integer.parseInt(tid);
		if(req.getAttribute("titleid")!=null){
		titleid = (Integer) req.getAttribute("titleid");
		}
		List<homework> list ;
		List<comment> list1;
		List<huifu> list2;
		List<score> list3;
		if(req.getParameter("huifuid")!=null){
		String sid = req.getParameter("huifuid");	
		int huifuid = Integer.parseInt(sid);
		
		
		
		huifu f;
		try {	
			f = dao1.updatexiaoxi(huifuid);
		req.setAttribute("f", f);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		mail c;
		try {
			c = dao1.updatemail(titleid);
			req.setAttribute("c", c);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				list= dao.gettitleid(titleid);
				req.setAttribute("list",list);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				list1= dao.commenttitleid(titleid);
				req.setAttribute("list1",list1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				list2=dao.huifutitleid(titleid);
				req.setAttribute("list2", list2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				list3=dao.xianshi2socre(titleid);
				req.setAttribute("list3", list3);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=req.getRequestDispatcher("/main2.jsp");
			rd.forward(req, res);
}
}