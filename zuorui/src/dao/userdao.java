package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import normal.homework;
import normal.mail;
import normal.user;
import util.jdbcutil;

public class userdao {
	public user queryByuser(String username) throws SQLException{		
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_user where username = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		user u = null;
		if (rs.next()) {
			int id = rs.getInt(1);
			String username1= rs.getString(2);
			String password= rs.getString(3);
			String type= rs.getString(4);
			String sex = rs.getString(5);
			String grade = rs.getString(6);
			int identification=rs.getInt(7);
			int mark=rs.getInt(8);
			u = new user(id, username1, password,type,sex,grade,identification,mark);
			
		}else{
					u = null;
				}
		jdbcutil.close(conn, pstm, rs);
		return u;
}
	public void insertuser(user w) throws SQLException{
		Connection conn = jdbcutil.getConnection();
		String sql = "insert into I_user(id,username,password,type,sex,grade,identification,mark) values(user_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, w.getUsername());
		pstm.setString(2, w.getPassword());
		pstm.setString(3, w.getType());
		pstm.setString(4, w.getSex());
		pstm.setString(5, w.getGrade());
		pstm.setInt(6, w.getIdentification());
		pstm.setInt(7, w.getMark());

		pstm.executeUpdate();
		

		jdbcutil.close(conn, pstm, null);
		}
	public void updatepass(user u) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_user set password=? where identification = ? and username=?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, u.getPassword());
	pstm.setInt(2, u.getIdentification());
	pstm.setString(3, u.getUsername());
	pstm.executeUpdate();
	jdbcutil.close(conn, pstm, null);

	}

	public user updatelogin(String username) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_user set mark=1 where username = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	
	
	pstm.setString(1, username);

	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);
	return null;
}
	public user updateflogin(String username) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_user set mark=0 where username = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	
	
	pstm.setString(1, username);

	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);
	return null;
}
	public List<user> getalluser() throws ClassNotFoundException,
	SQLException {
List<user> list = new ArrayList<user>();
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_user ORDER BY mark DESC";
PreparedStatement pstm  = conn.prepareStatement(sql);

ResultSet rs = pstm.executeQuery();
user u=null;
while(rs.next()){
	int id = rs.getInt(1);
	String username= rs.getString(2);
	String password= rs.getString(3);
	String type= rs.getString(4);
	String sex = rs.getString(5);
	String grade = rs.getString(6);
	int identification=rs.getInt(7);
	int mark=rs.getInt(8);
	u = new user(id, username, password,type,sex,grade,identification,mark);
	list.add(u);
	}
		jdbcutil.close(conn, pstm, rs);
			return list;
	}
}

