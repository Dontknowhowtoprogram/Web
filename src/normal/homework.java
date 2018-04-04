package normal;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;



@Searchable
public class homework {
	private int id;			//ID
	private String title;		//题目
	private String time;		//出题时间
	private int titleid;	//题目id
	private String textwork;//题目内容
	private int cmark;	//课程标记
	private String picture;//图片
		public homework() {
	}
	@SearchableId(name = "id", store = Store.YES, index = Index.NO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@SearchableProperty(name = "title", store = Store.YES, index = Index.ANALYZED)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@SearchableProperty(name = "time", store = Store.YES, index = Index.NO)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@SearchableId(name = "titleid", store = Store.YES, index = Index.NO)
	public int getTitleid() {
		return titleid;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
	public homework(int id, String title, String time, int titleid,String textwork,int cmark,String picture) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.titleid = titleid;
		this.textwork = textwork;
		this.cmark = cmark;
		this.picture = picture;
		
	}
	
	@SearchableProperty(name = "textwork", store = Store.YES, index = Index.ANALYZED)
	public String getTextwork() {
		return textwork;
	}
	public void setTextwork(String textwork) {
		this.textwork = textwork;
	}
	@Override
	public String toString() {
		return "homework [id=" + id + ", title=" + title + ", time=" + time
				+ ", titleid=" + titleid + ", textwork=" + textwork + "cmark=" + cmark + "picture=" + picture + "]";
	}
	public int getCmark() {
		return cmark;
	}
	public void setCmark(int cmark) {
		this.cmark = cmark;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
