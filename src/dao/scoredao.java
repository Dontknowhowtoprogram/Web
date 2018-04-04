package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import normal.comment;
import normal.homework;
import normal.huifu;
import normal.score;
import util.jdbcutil;

public class scoredao {
	public comment chengji(int textid) throws ClassNotFoundException, SQLException {
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

			// 创建一个Person对象，封装对应的值，
			a = new comment(textid, text, texttime, username, titleid,mark);

		}
		jdbcutil.close(conn, pstm, rs);
		return a;
	}
	public int insertscore(score s) throws ClassNotFoundException,
	SQLException {
Connection conn = jdbcutil.getConnection();
PreparedStatement pst1 = conn.prepareStatement("select I_score_seq.nextval from dual");
ResultSet rs = pst1.executeQuery();
rs.next();
int id = rs.getInt(1);
String sql = "insert into I_score(id, score, titleid, username,textid) values(?,?,?,?,?)";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1, id);
pstm.setInt(2, s.getScore());
pstm.setInt(3, s.getTitleid());
pstm.setString(4, s.getUsername());
pstm.setInt(5, s.getTextid());

pstm.executeUpdate();

jdbcutil.close(conn, pstm, null);
return id;
}
	
	public score fenshu(int textid) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		String sql = "select * from I_score where textid = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, textid);

		ResultSet rs = pstm.executeQuery();
		score a = null;
		while (rs.next()) {
			int id = rs.getInt(1);
			int score = rs.getInt(2);
			int title = rs.getInt(3);
			String username = rs.getString(4);
			int ctextid = rs.getInt(5);

			// 创建一个Person对象，封装对应的值，
			a = new score(id, score, title, username, ctextid);

		}
		jdbcutil.close(conn, pstm, rs);
		return a;
	}
	public int sum (String username) throws ClassNotFoundException, SQLException {
		Connection conn = jdbcutil.getConnection();
		
		String sql = "select sum(score) from I_score where username=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		int sum=0;
		while (rs.next()) {
		sum = rs.getInt("sum(score)");
			
		}
		
		jdbcutil.close(conn, pstm, rs);
		return sum;
	
		}
	public void updatescore(score s) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_score set score = ? where textid = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, s.getScore());
	pstm.setInt(2, s.getTextid());


	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);

}
	public void updatemark(comment c) throws ClassNotFoundException,
	SQLException {

	Connection conn = jdbcutil.getConnection();
	String sql = "update I_text set mark = 1 where textid = ?";

	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setInt(1, c.getTextid());
	pstm.executeUpdate();

	jdbcutil.close(conn, pstm, null);

}
}
