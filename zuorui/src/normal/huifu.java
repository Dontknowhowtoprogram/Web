package normal;

public class huifu {
	private String username;
	private int textid;
	private String name;
	private String intext;
	private int huifuid;
	private String nowtime;
	private int mark;
	private int titleid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTextid() {
		return textid;
	}
	public void setTextid(int textid) {
		this.textid = textid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntext() {
		return intext;
	}
	public void setIntext(String intext) {
		this.intext = intext;
	}
	public int getHuifuid() {
		return huifuid;
	}
	public void setHuifuid(int huifuid) {
		this.huifuid = huifuid;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public huifu(String username,int textid,String name,String intext,int huifuid,String nowtime,int mark,int titleid) {
		super();
		this.username = username;
		this.textid = textid;
		this.name = name;
		this.intext = intext;
		this.huifuid = huifuid;
		this.nowtime = nowtime;
		this.mark=mark;
		this.titleid=titleid;
}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getTitleid() {
		return titleid;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
}