package bean;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String username;
	private String password;
	private long userID;
    private	long phone;
    private String gender;//char不好接受输入
    private String birthYYD;
	
	public User()
	{
		super();
	}
	
	public User(long id,String username,String password,long userID,long phone,String gender,String birthYYD)
	{
		super();
		this.id=id;
		this.username=username;
		this.password=password;
		this.userID=userID;
		this.phone=phone;
		this.gender=gender;
		this.birthYYD=birthYYD;
	}
	public User(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username,long phone) 
	{
		super();
		this.username = username;
		this.phone=phone;
	}
	
	public long getid()
	{
		return id;
	}
	public void setid(long id) 
	{
		this.id = id;
	}
	public String getusername() 
	{
		return username;
	}
	public void setusername(String username) 
	{
		this.username = username;
	}
	public String getpassword() 
	{
		return password;
	}
	public void setpassword(String password) 
	{
		this.password = password;
	}
	public long getuserID() 
	{
		return userID;
	}
	public void setuserID(long userID) 
	{
		this.userID = userID;
	}
	public long getphone() 
	{
		return phone;
	}
	public void setphone(long phone)
	{
		this.phone = phone;
	}
	public String getgender() 
	{
		return gender;
	}
	public void setgender(String gender) 
	{
		this.gender = gender;
	}
	public String getbirthYYD()
	{
		return birthYYD;
	}
	public void setbirthYYD(String birthYYD)
	{
		this.birthYYD = birthYYD;
	}
	
	@Override
	public String toString() 
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userID=" + userID
				+ ",phone="+phone+",gender="+gender+",birthYYD="+birthYYD+"]";
	}
}