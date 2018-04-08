package normal;

public class user {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String type;
	private String grade;
	private int identification;
	private int mark;
	
	public user(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public user(int id, String username, String password, String type,String sex,String grade,int identification,int mark) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.sex = sex;
		this.grade = grade;
		this.identification=identification;
		this.mark=mark;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
