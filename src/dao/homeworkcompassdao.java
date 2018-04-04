package dao;

import java.util.ArrayList;
import java.util.List;

import normal.homework;

import org.compass.core.CompassHits;
import org.compass.core.CompassSession;

import util.compassutil;


public class homeworkcompassdao {
	public List<homework> queryBykeywords(String keyword) {
		CompassSession session = compassutil.getSession();
		CompassHits hits = session.find(keyword);
		List<homework> list = new ArrayList<homework>();
		for (int i = 0; i < hits.length(); i++) {
			homework h = (homework) hits.data(i);

			String title = hits.highlighter(i).fragment("title");
			String textwork = hits.highlighter(i).fragment("textwork");
			if(title!=null){
				h.setTitle(title);
			}
			if(textwork != null){
				h.setTextwork(textwork);
			}
			list.add(h);
		}
		session.close();
		return list;
	}

	
	public void inserthomework(homework h) {
		CompassSession session = compassutil.getSession();
		session.save(h);
		session.close();
	}

	public void updatehomework(homework h) {
		CompassSession session = compassutil.getSession();
		session.save(h);
		session.close();
	}

	public void deletehomework(int titleid) {
		homework h = new homework();
		h.setTitleid(titleid);
		CompassSession session = compassutil.getSession();
		session.delete(h);
		session.close();
	}
}
