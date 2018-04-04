package normal;

public class score {
	private int id;		//出题时间
	private int score;	//题目id
	private int titleid;
	private String username;
	private int textid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTitleid() {
		return titleid;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public score(int id,int score,int titleid,String username,int textid){
		super();
		this.id=id;
		this.score=score;
		this.titleid=titleid;
		this.username=username;
		this.textid=textid;
	}
	public int getTextid() {
		return textid;
	}
	public void setTextid(int textid) {
		this.textid = textid;
	}
}
