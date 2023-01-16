package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bean.User;
import lib.mysql.MySQLmanage;
import bean.Money;



public class ServerThread implements Runnable//继承Runnable接口，多个线程共享一个对象
{
	private Socket socket;
	private ObjectInputStream ois;//向客户端发送数据的输出流
	private ObjectOutputStream oos;//从客户端接受数据的输入流
	private HashMap<String, Object> toData;//向客户端发送数据的容器
	private HashMap<String, Object> getData;//从客户端接受数据的容器
	private boolean threadFlag = true;

	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
           
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		while (threadFlag) 
		{
			try {
				// 1.获得客户端发来的请求
				getMessage();
				// 2.处理客户端发来的请求
				service();
				// 3.回复客户端发来的请求
				toMessage();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				threadFlag = false;
			}
		}
	}

	
	private void toMessage()
	{
		try {
			oos.writeObject(toData);
			oos.flush();//强制清空缓存区
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * 方法：用于处理客户端发来的请求
	 */
	@SuppressWarnings("unused")
	private void service() {
		Integer type = (Integer) getData.get("type");
		switch (type) {
		// 10001：登录操作
		case 10001: {
			// 1.先接受从客户端发送的data，转换成user类型
			User user = (User) getData.get("data");
			// 2.操作UserServer 与数据库进行交互
			MySQLmanage m = new MySQLmanage();
			int i=0;
			//System.out.println(user.getusername());
			//System.out.println(user.getpassword());
			String s1="root";
			String s2="CS12345";
			if(user.getusername().equals(s1)&&user.getpassword().equals(s2))
			{
				 i=-1;
			}
			else
			{
				i=m.login(user);
			}
			// 3.根据返回结果，给客户端发送不同的信息
			switch (i) {
			case -1:
				// 1.管理员登录成功
			{
				setToMessage(20002, null); 
			}
				break;
			case 1:
				// 2.用户登录成功
				setToMessage(20001, null);
				break;
			case 0:
				// -1.登录失败，密码错误或用户名不存在
				setToMessage(20003, null);
				break;
			}break;
			
		}
		
		// 10016：学员修改自身密码操作
		case 10016:{
			//1. 用于接受客户端发来的数据
			User[] user=(User[]) getData.get("data");
			//2. 操作数据库
			MySQLmanage f = new MySQLmanage();
			boolean updateFlag=f.userUpdateString(user[0], user[1]);
			//3. 根据数据库的返回结果，给客户端不同的回复
			if(updateFlag){
				setToMessage(20014,null);
			}
			else{
				setToMessage(20015,null);
			}
			
		}
		break;
		
		// 10017：学员修改自身手机号操作
		case 10017:{
					//1. 用于接受客户端发来的数据
					User[] user=(User[]) getData.get("data");
					//2. 操作数据库
					MySQLmanage f = new MySQLmanage();
					boolean updateFlag=f.userUpdateLong(user[0], user[1]);
					//3. 根据数据库的返回结果，给客户端不同的回复
					if(updateFlag){
						setToMessage(20016,null);
					}
					else{
						setToMessage(20017,null);
					}
				}break;
		//	10010:查询余额
		case 10010:{
			String username=(String) getData.get("data");
			MySQLmanage g = new MySQLmanage();
			double money1=g.moneySelect(username);
			if(money1!=-1.0){
				//余额查询成功
				setToMessage(20008,money1);
			}
			if(money1==-1.0){
				//余额查询失败
				setToMessage(20018,null);
			}
		}break;
		
		//	10011:取钱
		case 10011:{
			MySQLmanage m = new MySQLmanage();
			Money money=(Money) getData.get("data");
			double money2=m.moneySelect(money.getusername());
			double money3=money.getbalance();
			double money4=money2-money3;
			money.setbalance(money4);
			boolean updateFlag=m.moneyAdd(money);
			//double money2=m.moneySelect(money.getusername());
			if(updateFlag){
				//取钱成功
				setToMessage(20009,money4);
			}else{
				//取钱失败
				setToMessage(20010,null);
			}
		}break;
		//	10012:存钱
		case 10012:{
			MySQLmanage m = new MySQLmanage();
			Money money=(Money) getData.get("data");
			double money2=m.moneySelect(money.getusername());
			double money3=money.getbalance();
			double money4=money2+money3;
			money.setbalance(money4);
			boolean updateFlag=m.moneyAdd(money);
			//double money2=m.moneySelect(money.getusername());
			if(updateFlag){
				//存钱成功
				setToMessage(20011,money4);
				System.out.println("cnm");
			}else{
				//存钱失败
				setToMessage(20019,null);
			}
		}break;
		//	10013:转账1
		case 10013:{
			MySQLmanage m = new MySQLmanage();
			Money money=(Money) getData.get("data");
			double money2=m.moneySelect(money.getusername());
			double money3=money.getbalance();
			double money4=money2-money3;
			money.setbalance(money4);
			boolean updateFlag=m.moneyAdd(money);
			//double money2=m.moneySelect(money.getusername());
			if(updateFlag){
				//转账1成功
				setToMessage(20012,money4);
			}else{
				//转账1失败
				setToMessage(20013,null);
			}
		}break;
		//	10014:转账2
		case 10014:{
			MySQLmanage m = new MySQLmanage();
			Money money=(Money) getData.get("data");
			double money2=m.moneySelect(money.getusername());
			double money3=money.getbalance();
			double money4=money2+money3;
			money.setbalance(money4);
			boolean addTestFlag=m.moneyAdd(money);
			if(addTestFlag){
				//转账成功
				setToMessage(20012,money4);
			}else{
				setToMessage(20013,null);
			}
		}break;
		
		//	10003：管理员开
		case 10003:{
			User user=(User) getData.get("data");
			MySQLmanage f = new MySQLmanage();
			boolean updateFlag=f.insert(user);
			if(updateFlag){
				//管理员开成功
				setToMessage(20004,null);
			}else{
				//管理员开失败
				setToMessage(20005,null);
			}
		}break;
		//	10004:银行送	
		/*case 10004:{
			Money money=(Money) getData.get("data");
			boolean updateTest=TestServer.updateTest(t);
			if(updateTest){
				//银行送成功
				setToMessage(20004,null);
			}else{
				//银行送失败
				setToMessage(20005,null);
			}
		}break;
		*/
		//10005:销户
		case 10005:{
			String username=(String) getData.get("data");
			MySQLmanage f = new MySQLmanage();
			boolean updateFlag=f.delete(username);
			if(updateFlag){
				//销户成功
				setToMessage(20006,null);
			}else{
				//销户失败
				setToMessage(20007,null);
			}
		}break;
		/*
		//10007:导出xls
		case 10007:{
			int number=(int) getData.get("data");
			switch(number)
			{
			case 1:
			//需要导出ID文件的数据库函数
			break;
			case 2:
			//需要导出用户名文件的数据库函数
			break;
			case 3:
		    //需要导出UserID文件的数据库函数
			break;
			case 4:
			//需要导出phone文件的数据库函数
			break;
			case 5:
			//需要导出gender文件的数据库函数
			break;
			case 6:
			//需要导出birthday文件的数据库函数
			break;
			case 7:
			//需要导出balance文件的数据库函数
			break;
			}
			if(set!=null){//导出xls成功
				setToMessage(20020,set);
			}else{
				//导出xls失败
				setToMessage(20021,null);
			}
		}break;
		
		//10006:导入xls文件
		case 10006:{
			//导入xls文件的数据库函数
			if(b){//导入xls文件的数据库函数成功
				setToMessage(20022,null);
			}else{//导入xls文件的数据库函数失败
				setToMessage(20023,null);
			}
		}break;
		//10008:导出pdf文件
		case 10008:{
			//导出pdf文件的数据库函数
			if(list!=null){//导出pdf文件的数据库函数成功
				setToMessage(20024,list);
			}else{//导出pdf文件的数据库函数失败
				setToMessage(20025,null);
			}
		}break;
		*/
		}

	}

	/**
	 * 方法：用于得到客户端发来的请求
	 * 
	 * @throws Exception
	 */
	private void getMessage() throws Exception 
	{
		getData = (HashMap<String, Object>) ois.readObject();
	}

	/**
	 * 方法：用于将消息类型和所需数据装入容器中
	 * 
	 * @param type
	 *            消息类型
	 * @param data
	 *            所需数据
	 */
	private void setToMessage(int type, Object data)
	{
		toData = new HashMap<String, Object>();
		toData.put("type", type);
		toData.put("data", data);
	}

}
