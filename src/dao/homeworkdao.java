package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import javax.xml.crypto.Data;

import normal.comment;
import normal.homework;
import normal.huifu;
import normal.mail;
import normal.score;

import util.jdbcutil;


public class homeworkdao {
	
	public List<homework> getAllPersons() throws ClassNotFoundException,
	SQLException {
List<homework> list = new ArrayList<homework>();
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_homework ORDER BY time DESC";
PreparedStatement pstm  = conn.prepareStatement(sql);

ResultSet rs = pstm.executeQuery();

while(rs.next()){
	int id = rs.getInt(1);
	String title = rs.getString(2);
	String time = rs.getString(3);
	int titleid = rs.getInt(4);
	String textwork = rs.getString(5);
	int cmark = rs.getInt(6);
	String picture = rs.getString(7);
	homework h = new homework(id, title, time, titleid, textwork,cmark,picture);
	list.add(h);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	
	public int insertmessage(comment c) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_text_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int textid = rs.getInt(1);
String sql = "insert into I_text(textid,text,texttime,username,titleid,mark) values(?,?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1, textid);
pstm.setString(2, c.getText());
pstm.setString(3, c.getTexttime());
pstm.setString(4, c.getUsername());
pstm.setInt(5, c.getTitleid());
pstm.setInt(6, c.getMark());
pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
return textid;
}
	
	public homework queryById(int titleid) throws ClassNotFoundException, SQLException {
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
			c = new homework(id, title, time, titleid, textwork,cmark,picture);

		}
		jdbcutil.close(conn, pstm, rs);
		return c;
	}
	

	public List<comment> xianshicomment() throws ClassNotFoundException,
	SQLException {
List<comment> list = new ArrayList<comment>();//存储封装好的Person对象
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_text ORDER BY texttime DESC";

PreparedStatement pstm  = conn.prepareStatement(sql);
ResultSet rs = pstm.executeQuery();
while(rs.next()){
	int textid = rs.getInt(1);
	String text = rs.getString(2);
	String texttime = rs.getString(3);
	String username = rs.getString(4);
	int titleid = rs.getInt(5);
	int mark=rs.getInt(6);
	comment c = new comment(textid, text, texttime, username, titleid,mark);
	list.add(c);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	public List<comment> xianshimycomment(String username,int titleid) throws ClassNotFoundException,
	SQLException {
List<comment> list = new ArrayList<comment>();//存储封装好的Person对象
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_text where username =? and titleid=?";
PreparedStatement pstm  = conn.prepareStatement(sql);
pstm.setString(1, username);
pstm.setInt(2, titleid);
ResultSet rs = pstm.executeQuery();
while(rs.next()){
	int textid = rs.getInt(1);
	String text = rs.getString(2);
	String texttime = rs.getString(3);
	String cusername = rs.getString(4);
	int ctitleid = rs.getInt(5);
	int mark=rs.getInt(6);
	comment c = new comment(textid, text, texttime, username, titleid,mark);
	list.add(c);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	
	public void deletebyId(int textid) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();

String sql = "delete from I_text where textid = ?";
String sqll = "delete from I_huifu where textid = ?";
String sqlll = "delete from I_score where textid = ?";
PreparedStatement pstm = conn.prepareStatement(sql);
PreparedStatement pstm1 = conn.prepareStatement(sqll);
PreparedStatement pstm2 = conn.prepareStatement(sqlll);
pstm.setInt(1, textid);
pstm1.setInt(1, textid);
pstm2.setInt(1, textid);
pstm.executeUpdate();
pstm1.executeUpdate();
pstm2.executeUpdate();
jdbcutil.close(conn, pstm, null);
}
	public List<huifu> huifuuser() throws ClassNotFoundException,
	SQLException {
List<huifu> list = new ArrayList<huifu>();//存储封装好的Person对象
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_huifu ORDER BY nowtime DESC";
PreparedStatement pstm  = conn.prepareStatement(sql);
ResultSet rs = pstm.executeQuery();
while(rs.next()){
	String username= rs.getString(1);
	int textid = rs.getInt(2);
	String name = rs.getString(3);
	String intext = rs.getString(4);
	int huifuid = rs.getInt(5);
	String nowtime = rs.getString(6);
	int mark = rs.getInt(7);
	int titleid= rs.getInt(8);
	huifu c = new huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid);
	list.add(c);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	public int inserthuifu(huifu c) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_huifu_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int huifuid = rs.getInt(1);
String sql = "insert into I_huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid) values(?,?,?,?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, c.getUsername());
pstm.setInt(2, c.getTextid());
pstm.setString(3, c.getName());
pstm.setString(4, c.getIntext());
pstm.setInt(5, huifuid);
pstm.setString(6, c.getNowtime());
pstm.setInt(7, c.getMark());
pstm.setInt(8, c.getTitleid());
pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
return huifuid;
}
	public comment sousuobyid(int textid) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_text where textid = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, textid);

		ResultSet rs = pstm.executeQuery();
		comment a = null;
		while (rs.next()) {
			int ctextid = rs.getInt(1);
			String text = rs.getString(2);
			String texttime = rs.getString(3);
			String username = rs.getString(4);
			int titleid = rs.getInt(5);
			int mark=rs.getInt(6);

			
			a = new comment(textid, text, texttime, username, titleid,mark);

		}
		jdbcutil.close(conn, pstm, rs);
		return a;
	}
	public huifu sousuohuifubyid(int huifuid) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_huifu where huifuid = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, huifuid);

		ResultSet rs = pstm.executeQuery();
		huifu f = null;
		while (rs.next()) {
			String username = rs.getString(1);
			int textid = rs.getInt(2);
			String name = rs.getString(3);
			String intext = rs.getString(4);
			int chuifuid = rs.getInt(5);
			String nowtime = rs.getString(6);
			int mark = rs.getInt(7);
			int titleid= rs.getInt(8);
			f = new huifu(username, textid, name, intext, huifuid,nowtime,mark,titleid);

		}
	
		jdbcutil.close(conn, pstm, rs);
		return f;
	}
	
	
	public int huifuxiaoxi(huifu c) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_huifu_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int huifuid = rs.getInt(1);
String sql = "insert into I_huifu(username, textid, name, intext, huifuid,nowtime,mark) values(?,?,?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setString(1, c.getUsername());
pstm.setInt(2, c.getTextid());
pstm.setString(3, c.getName());
pstm.setString(4, c.getIntext());
pstm.setInt(5, huifuid);
pstm.setString(6, c.getNowtime());
pstm.setInt(7, c.getMark());
pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
return huifuid;
}
	public void deletehuifuId(int textid) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();

String sql = "delete from I_huifu where huifuid = ?";

PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1, textid);

pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
}
	public int inserthomework(homework h) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_homework_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int titleid = rs.getInt(1);
String sql = "insert into I_homework(titleid,title,time,textwork,id,cmark,picture) values(?,?,?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1, titleid);
pstm.setString(2, h.getTitle());
pstm.setString(3, h.getTime());
pstm.setString(4, h.getTextwork());
pstm.setInt(5,h.getId());
pstm.setInt(6,h.getCmark());
pstm.setString(7, h.getPicture());
pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);

return titleid;
}
	public void deletehomeworkId(int titleid) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();

String sql = "delete from I_homework where titleid = ?";
String sqll = "delete from I_text where titleid = ?";
String sqlll = "delete from I_huifu where titleid = ?";
String sqllll = "delete from I_score where titleid = ?";
PreparedStatement pstm = conn.prepareStatement(sql);
PreparedStatement pstm1 = conn.prepareStatement(sqll);
PreparedStatement pstm2 = conn.prepareStatement(sqlll);
PreparedStatement pstm3 = conn.prepareStatement(sqllll);
pstm.setInt(1, titleid);
pstm1.setInt(1, titleid);
pstm2.setInt(1, titleid);
pstm3.setInt(1, titleid);
pstm.executeUpdate();
pstm1.executeUpdate();
pstm2.executeUpdate();
pstm3.executeUpdate();
jdbcutil.close(conn, pstm, null);
}
	public void update(homework h) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_homework set id=?, title = ?,time = ?,textwork = ?,cmark = ?,picture = ? where titleid = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, h.getId());
	pstm.setString(2, h.getTitle());
	pstm.setString(3, h.getTime());
	pstm.setString(4, h.getTextwork());
	pstm.setInt(5, h.getCmark());
	pstm.setString(6, h.getPicture());
	pstm.setInt(7, h.getTitleid());
	

	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);

}
	public huifu updatexiaoxi(int huifuid) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_huifu set mark=1 where huifuid = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	
	
	pstm.setInt(1, huifuid);

	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);
	return null;

}
	public mail updatemail(int titleid) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_mail set mark=1 where titleid = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	
	
	pstm.setInt(1, titleid);

	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);
	return null;
}
	public List<score> xianshisocre() throws ClassNotFoundException,
	SQLException {
List<score> list = new ArrayList<score>();//存储封装好的Person对象
Connection conn = jdbcutil.getConnection();
String sql = "select * from I_score";
PreparedStatement pstm  = conn.prepareStatement(sql);
ResultSet rs = pstm.executeQuery();
while(rs.next()){
	int id = rs.getInt(1);
	int score = rs.getInt(2);
	int titleid = rs.getInt(3);
	String username= rs.getString(4);
	int textid = rs.getInt(5);
	score x = new score(id, score, titleid, username,textid);
	list.add(x);
}
jdbcutil.close(conn, pstm, rs);
return list;
	}
	public int count (String username) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		
		String sql = "select count(*) from I_huifu where mark=0 and username=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		int count=0;
		while (rs.next()) {
		count = rs.getInt("count(*)");
			
		}
		
		jdbcutil.close(conn, pstm, rs);
		return count;
	
		}
	public int countm (String username) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		
		String sql = "select count(*) from I_mail where mark=0 and username=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		int countm=0;
		while (rs.next()) {
		countm = rs.getInt("count(*)");
			
		}
		
		jdbcutil.close(conn, pstm, rs);
		return countm;
	
		}
	public List<homework> queryBymark(int cmark) throws ClassNotFoundException, SQLException {
		List<homework> list = new ArrayList<homework>();
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_homework where cmark = ? ORDER BY time DESC";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, cmark);

		ResultSet rs = pstm.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String title = rs.getString(2);
			String time = rs.getString(3);
			int titleid = rs.getInt(4);
			String textwork = rs.getString(5);
			int ccmark = rs.getInt(6);
			String picture = rs.getString(7);
			homework c = new homework(id, title, time, titleid, textwork,cmark,picture);
			list.add(c);

		}
		jdbcutil.close(conn, pstm, rs);
		return list;
	}
	
}
