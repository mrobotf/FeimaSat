package bean;
import java.io.Serializable;

public class Money implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String username;
	private double balance;
	public Money()
	{
		super();
	}
	public Money(String username,double balance)
	{
		super();
		this.username=username;
		this.balance=balance;
	}
	public String getusername()
	{
		return username;
	}
	public void setusername(String username) 
	{
		this.username = username;
	}
	public double getbalance() 
	{
		return balance;
	}
	public void setbalance(double balance) 
	{
		this.balance= balance;
	}
	@Override
	public String toString() 
	{
		return "Money [username=" + username + ", balance=" + balance + "]";
	}
}
