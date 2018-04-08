package normal;

import java.sql.SQLException;
import java.util.List;

import dao.homeworkcompassdao;
import dao.homeworkdao;


public class InitIndex {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		homeworkcompassdao cdao = new homeworkcompassdao();
		homeworkdao dao = new homeworkdao();
		
		List<homework> list = dao.getAllPersons();
		for(homework h:list){
			cdao.inserthomework(h);
		}
	}
}
