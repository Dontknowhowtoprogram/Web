package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import normal.comment;
import normal.homework;
import normal.huifu;
import normal.mail;
import normal.score;
import util.jdbcutil;

public class senddao {
	public List<huifu> xiaoxi(String username) throws ClassNotFoundException,
	SQLException {
List<huifu> list = new ArrayList<huifu>();
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_huifu where username = ? and mark = 0 ORDER BY huifuid DESC";
PreparedStatement pstm  = conn.prepareStatement(sql);
pstm.setString(1, username);
ResultSet rs = pstm.executeQuery();

while(rs.next()){
	String cusername= rs.getString(1);
	int textid = rs.getInt(2);
	String name = rs.getString(3);
	String intext = rs.getString(4);
	int huifuid = rs.getInt(5);
	String nowtime = rs.getString(6);
	int mark = rs.getInt(7);
	int titleid = rs.getInt(8);
	huifu c = new huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid);
	list.add(c);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	public int insertmail(mail c) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_mail_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int mailid = rs.getInt(1);
String sql = "insert into I_mail(mailid, username,title, textwork,name,time,mark,titleid) values(?,?,?,?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1,mailid);
pstm.setString(2, c.getUsername());
pstm.setString(3, c.getTitle());
pstm.setString(4, c.getTextwork());
pstm.setString(5, c.getName());
pstm.setString(6, c.getTime());
pstm.setInt(7, c.getMark());
pstm.setInt(8, c.getTitleid());
pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
return mailid;
}
	public homework mailById(int titleid) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_homework where titleid = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, titleid);

		ResultSet rs = pstm.executeQuery();
		homework c = null;
		while (rs.next()) {
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String time = rs.getString(3);
			int ctitleid = rs.getInt(4);
			String textwork = rs.getString(5);
			int cmark = rs.getInt(6);
			String picture = rs.getString(7);

			// 创建一个Person对象，封装对应的值，
			c = new homework(id, title, time, titleid, textwork,cmark,picture);

		}
		jdbcutil.close(conn, pstm, rs);
		return c;
	}
		public List<mail> mail(String username) throws ClassNotFoundException,
		SQLException {
	List<mail> list = new ArrayList<mail>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_mail where username = ? and mark = 0 ORDER BY time DESC";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setString(1, username);
	ResultSet rs = pstm.executeQuery();

	while(rs.next()){
		int mailid = rs.getInt(1);
		String cusername= rs.getString(2);
		String title = rs.getString(3);
		String textwork = rs.getString(4);
		String name = rs.getString(5); 
		int mark = rs.getInt(6);
		String time = rs.getString(7);
		int titleid=rs.getInt(8);
		mail m = new mail(mailid,username, title,textwork,name,mark,time,titleid);
		list.add(m);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
}
		public List<homework> gettitleid(int titleid) throws ClassNotFoundException,
		SQLException {
	List<homework> list = new ArrayList<homework>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_homework where titleid=?";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setInt(1, titleid);
	ResultSet rs = pstm.executeQuery();

	while(rs.next()){
		int id = rs.getInt(1);
		String title = rs.getString(2);
		String time = rs.getString(3);
		int ctitleid = rs.getInt(4);
		String textwork = rs.getString(5);
		int cmark = rs.getInt(6);
		String picture = rs.getString(7);
		homework h = new homework(id, title, time, titleid, textwork,cmark,picture);
		list.add(h);
		
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
		}
		public List<comment> commenttitleid(int titleid) throws ClassNotFoundException,
		SQLException {
	List<comment> list = new ArrayList<comment>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_text where titleid=?";

	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setInt(1, titleid);
	ResultSet rs = pstm.executeQuery();
	while(rs.next()){
		int textid = rs.getInt(1);
		String text = rs.getString(2);
		String texttime = rs.getString(3);
		String username = rs.getString(4);
		int ctitleid = rs.getInt(5);
		int mark=rs.getInt(6);
		comment c = new comment(textid, text, texttime, username, titleid,mark);
		list.add(c);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
		}
		public List<huifu> huifutitleid(int titleid) throws ClassNotFoundException,
		SQLException {
	List<huifu> list = new ArrayList<huifu>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_huifu where titleid=?";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setInt(1, titleid);
	ResultSet rs = pstm.executeQuery();
	while(rs.next()){
		String username= rs.getString(1);
		int textid = rs.getInt(2);
		String name = rs.getString(3);
		String intext = rs.getString(4);
		int huifuid = rs.getInt(5);
		String nowtime = rs.getString(6);
		int mark = rs.getInt(7);
		int ctitleid= rs.getInt(8);
		huifu c = new huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid);
		list.add(c);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
		}
		public List<score> xianshi2socre(int titleid) throws ClassNotFoundException,
		SQLException {
	List<score> list = new ArrayList<score>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_score where titleid=?";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setInt(1, titleid);
	ResultSet rs = pstm.executeQuery();
	while(rs.next()){
		int id = rs.getInt(1);
		int score = rs.getInt(2);
		int ctitleid = rs.getInt(3);
		String username= rs.getString(4);
		int textid = rs.getInt(5);
		score x = new score(id, score, titleid, username,textid);
		list.add(x);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
		}
		
		public List<huifu> allxiaoxi(String username) throws ClassNotFoundException,
		SQLException {
	List<huifu> list = new ArrayList<huifu>();
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_huifu where username = ?  ORDER BY huifuid DESC";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setString(1, username);
	ResultSet rs = pstm.executeQuery();

	while(rs.next()){
		String cusername= rs.getString(1);
		int textid = rs.getInt(2);
		String name = rs.getString(3);
		String intext = rs.getString(4);
		int huifuid = rs.getInt(5);
		String nowtime = rs.getString(6);
		int mark = rs.getInt(7);
		int titleid = rs.getInt(8);
		huifu c = new huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid);
		list.add(c);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
		}
		
		public List<mail> allmail(String username) throws ClassNotFoundException,
		SQLException {
	List<mail> list = new ArrayList<mail>();//存储封装好的Person对象
	Connection conn = jdbcutil.getConnection();
	String sql = "select * from I_mail where username = ? ORDER BY time DESC";
	PreparedStatement pstm  = conn.prepareStatement(sql);
	pstm.setString(1, username);
	ResultSet rs = pstm.executeQuery();

	while(rs.next()){
		int mailid = rs.getInt(1);
		String cusername= rs.getString(2);
		String title = rs.getString(3);
		String textwork = rs.getString(4);
		String name = rs.getString(5); 
		int mark = rs.getInt(6);
		String time = rs.getString(7);
		int titleid=rs.getInt(8);
		mail m = new mail(mailid,username, title,textwork,name,mark,time,titleid);
		list.add(m);
	}
	jdbcutil.close(conn, pstm, rs);
	return list;
}
}
