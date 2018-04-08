package normal;

public class comment {
	private int textid;
	private String text;
	private String texttime;
	private String username;
	private int titleid;
	private int mark;
	public int getTextid() {
		return textid;
	}
	public void setTextid(int textid) {
		this.textid = textid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTexttime() {
		return texttime;
	}
	public void setTexttime(String texttime) {
		this.texttime = texttime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTitleid() {
		return titleid;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
	public comment(int textid, String text, String texttime, String username,int titleid,int mark) {
		super();
		this.textid = textid;
		this.text = text;
		this.texttime = texttime;
		this.username = username;
		this.titleid = titleid;
		this.mark=mark;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
}
