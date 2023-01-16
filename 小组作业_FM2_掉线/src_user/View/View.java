package View;

import java.util.Scanner;

import bean.Money;
import bean.User;

public class View{
	 	//欢迎总界面
	 	public static User HelloView()
	 	{
	 		Scanner input=new Scanner(System.in);
			System.out.println("**********\t欢迎来到飞马银行\t\t**********");
			System.out.println("**********\t请根据系统提示进行操作\t**********");
			System.out.println("**********\t若要登录为管理员身份，用户名：“root”\t**********");
			System.out.println("**********\t请输入您的用户名\t\t**********");
			String username=input.nextLine();
			System.out.println("**********\t若要登录为管理员身份，密码：“CS12345”\t**********");
			System.out.println("**********\t请输入您的密码\t\t**********");
			String password=input.nextLine();
			return new User(username,password);
	 	}
	 	
	 	
		/**
		 * 用户欢迎界面
		 * */
		public static int userView(){
			Scanner input=new Scanner(System.in);
			int type=-1;
			System.out.println("**********\t欢迎登录飞马银行用户系统\t**********");
			System.out.println("**********\t请根据系统提示进行操作\t**********");
			System.out.println("**********\t0.退出\t**********");
			System.out.println("**********\t1.查询余额\t**********");//要在客户端显示
			System.out.println("**********\t2.取钱\t**********");
			System.out.println("**********\t3.存钱\t**********");
			System.out.println("**********\t4.转账\t**********");
			System.out.println("**********\t5.修改用户密码信息\t**********");
			System.out.println("**********\t6.修改用户手机号信息\t**********");
			String text=input.nextLine();
			try{
				type=Integer.parseInt(text);
			}catch(NumberFormatException e){
			}
			if(type<0||type>6){
				System.out.println("您输入的有误，请重新输入");
				return userView();
			}
			return type;
		}
		/**
		 * 飞马银行管理员欢迎界面
		 * */
		public static int managerView(){
			Scanner input=new Scanner(System.in);
			int type=-1;
			System.out.println("**********\t欢迎登录飞马银行管理员系统\t**********");
			System.out.println("**********\t0.退出\t\t**********");
			System.out.println("**********\t1.开户\t\t**********");
			System.out.println("**********\t2.销户\t\t**********");
			System.out.println("**********\t3.导入xls批量开户\t\t**********");//没写
			System.out.println("**********\t4.导出xls\t\t**********");
			System.out.println("**********\t5.导出pdf\t\t**********");//没写
			String text=input.nextLine();
			try {
				type=Integer.parseInt(text);
			} catch (NumberFormatException e) {
			}
			if(type<0||type>5){
				System.out.println("输入有误，请重新输入");
				return managerView();
			}
			return type;
		}
		/**
		 * 开户界面(不止用户和密码)
		 * */
		public static User AddUserView(){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t开户界面\t**********");
			System.out.println("**********\t请输入用户名（输入范例：zhnb）\t**********");
			String username=input.nextLine();
			System.out.println("**********\t请输入用户密码（输入范例：20060522123）\t**********");
			String password=input.nextLine();
			System.out.println("**********\t请输入用户性别（输入范例：F/M）\t**********");
			String gender=input.nextLine();
			System.out.println("**********\t请输入用户出生日期（输入范例：2020-01-09）\t**********");
			String birthYYd=input.nextLine();
			System.out.println("**********\t请输入用户身份id（输入范例：3501232202）\t**********");
			long userID=input.nextLong();
			System.out.println("**********\t请输入用户账户id（输入范例：12345543）\t**********");
			long id=input.nextLong();
			System.out.println("**********\t请输入用户电话号码（输入范例：13860670183）\t**********");
			long phone=input.nextLong();
			return new User(id,username,password,userID,phone,gender,birthYYd);
			
		}
		/*public static Money AddMenoyView(){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t银行开户充值界面\t**********");
			System.out.println("**********\t请输入用户名\t**********");
			String username=input.nextLine();
			double balance=2000.00;
			return new Money(username,balance);
			
		}
		*/
		/**
		 * 销户界面
		 * */
		public static String delUserView(){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t销户界面\t**********");
			System.out.println("**********\t请输入用户名\t**********");
			String username=input.nextLine();
			return username;
		}
		/**
		 * 查找用户余额界面
		 * */
		public static void FindUserView()
		{
			System.out.println("**********\t查找余额界面\t**********");
		}
		/**
		 * 转账界面
		 * */
		public static void  transView1() 
		{
			System.out.println("**********\t转账界面\t**********");
		}
		public static double transView11() 
		{
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t请输入需转出多少钱\t**********");
			double balance=input.nextDouble();
			return balance;
			
		}
		public static String transView2()
		{
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t请输入转入用户名\t**********");
			String username=input.nextLine();
			return username;
		}
		/**
		 * 存钱界面
		 * */
		public static double cunView11() 
		{
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t请输入需存入多少钱\t**********");
			double balance=input.nextDouble();
			return balance;
		}
		/**
		 * 取钱界面
		 * */
		public static double quView11() 
		{
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t请输入需取出多少钱\t**********");
			double balance=input.nextDouble();
			return balance;
		}
		
		/**
		 * 导出xls界面
		 * */
		public static int DriveView(){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t导出信息界面\t**********");
			System.out.println("**********\t请输入需要导出的数据的序号\t**********");
			System.out.println("**********\t需要导出ID输入1\t**********");
			System.out.println("**********\t需要导出用户名输入2\t**********");
			System.out.println("**********\t需要导出userID输入3\t**********");
			System.out.println("**********\t需要导出phone输入4\t**********");
			System.out.println("**********\t需要导出gender输入5\t**********");
			System.out.println("**********\t需要导出birthday输入6\t**********");
			System.out.println("**********\t需要导出余额输入7\t**********");
			int number=input.nextInt();
			switch(number)
			{
			case 1:System.out.println("需要导出ID");break;
			case 2:System.out.println("需要导出用户名");break;
			case 3:System.out.println("需要导出userID");break;
			case 4:System.out.println("需要导出phone");break;
			case 5:System.out.println("需要导出gender");break;
			case 6:System.out.println("需要导出birthday");break;
			case 7:System.out.println("需要导出余额");break;
			}
			return number;

		}
		/**
		 * 修改密码界面
		 * */
		public static User updateUserView(User user){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t修改密码界面\t**********");
			System.out.println("**********\t请输入用户原密码\t**********");
			String oldPwd=input.nextLine();
			System.out.println("**********\t请输入用户新密码\t**********");
			String newPwd1=input.nextLine();
			System.out.println("**********\t请再次输入用户新密码\t**********");
			String newPwd2=input.nextLine();
			if(newPwd1!=null&&newPwd1.equals(newPwd2)){
				user.setpassword(oldPwd);
				return new User(null,newPwd1);
			}else{
				System.out.println("两次密码不一致，请重新输入");
				return updateUserView(user);
			}
			
		}
		/**
		 * 修改手机号界面
		 * */
		public static User updateUserView_t(User user){
			Scanner input=new Scanner(System.in);
			System.out.println("**********\t修改手机号界面\t**********");
			System.out.println("**********\t请输入用户原手机号\t**********");
			long oldPwd=input.nextLong();
			System.out.println("**********\t请输入用户新手机号\t**********");
			long newPwd1=input.nextLong();
			System.out.println("**********\t请再次输入用户新手机号\t**********");
			long newPwd2=input.nextLong();
			if(newPwd1!=0&&newPwd1==newPwd2){
				user.setphone(oldPwd);
				return new User(null,newPwd1);
			}else{
				System.out.println("两次手机号不一致，请重新输入");
				return updateUserView_t(user);
			}
			
		}
}