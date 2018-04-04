package password;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import normal.user;

import dao.homeworkcompassdao;
import dao.homeworkdao;
import dao.userdao;


public class findpassword extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String type = new String("1");
		String sex = req.getParameter("sex");
		String grade = req.getParameter("grade");
		String idd=req.getParameter("identification");
		int identification = Integer.parseInt(idd); 
		String imark=req.getParameter("mark");
		int mark = Integer.parseInt(imark);
		user u = new user(0, username, password, type, sex, grade,identification,mark);
		userdao dao = new userdao();
			try {
				dao.updatepass(u);
				
					res.sendRedirect("/zuorui/login.jsp");
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

}

