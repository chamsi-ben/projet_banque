package Ben.banques;

public class Login {
	private String username;
	private String pwd;
	
	public Login(String user, String p)
	{
		username = user;
		pwd = p;
	}
	public Login()
	{
		
	}

	public String log()
	{
		return username+"-"+pwd;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
