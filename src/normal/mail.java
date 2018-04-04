package normal;

public class mail {
	private int mailid;
	private String username;
	private String title;
	private String textwork;
	private String name;
	private int mark;
	private String time;
	private int titleid;
	public int getMailid() {
		return mailid;
	}
	public void setMailid(int mailid) {
		this.mailid = mailid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTextwork() {
		return textwork;
	}
	public void setTextwork(String textwork) {
		this.textwork = textwork;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public mail(int mailid,String username,String title,String textwork,String name,int mark,String time,int titleid){
		super();
		this.mailid=mailid;
		this.username=username;
		this.title=title;
		this.textwork=textwork;
		this.name=name;
		this.mark=mark;
		this.time = time;
		this.titleid= titleid;
	}
	public int getTitleid() {
		return titleid;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
}
