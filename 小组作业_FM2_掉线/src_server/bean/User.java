package bean;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String username;
	private String password;
	private long userID;
    private	long phone;
    private String gender;
    private String birthYYD;
	//private double balance;
	private int number;                    // 用于选择xls导出对象
	
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
		//this.balance=balance;
		//this.number=number;
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
	
	public User(int number) 
	{
		super();
		this.number=number;
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
	/*public double getbalance() 
	{
		return balance;
	}
	public void setbalance(double balance)
	{
		this.balance= balance;
	}
	*/
	//public double getnumber() 
	//{
		//return number;
	//}
	//public void setnumber(int number)
	//{
		//this.number= number;
	//}
	@Override
	public String toString() 
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userID=" + userID
				+ ",phone="+phone+",gender="+gender+",birthYYD="+birthYYD+",number="+number+"]";
	}
}