package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import bean.Money;
import bean.User;
import View.View;

public class ClientMain {
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	private static HashMap toData;
	private static HashMap getData;
	private static String username =null;
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
			try {
				Socket s = new Socket("172.23.42.93", 11111);
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream());
				User user = View.HelloView();
			    username = user.getusername();
				toMessage(10001, user);//登录端口号
				getMessage();
				Integer type = (Integer) getData.get("type");
				switch(type)
				{
				case 20001:
					ClientInterface();//用户登录
					break;
				case 20002:
					ManageInterface();//管理员登录
					break;
				case 20003:
					System.out.println("error");
					break;
				}
				try
				{
					System.out.println(ois.readObject());
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
			catch (UnknownHostException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
	}
	
	private static void ManageInterface()//柜台人员登陆后对应的窗口方法
	{
		// TODO Auto-generated method stub
		while(true)
		{
			int i= View.managerView();
			switch(i)
			{
			case 0:
				System.exit(0);
				break;
				//退出
			case 1:
				//开户
			{
				User user = View.AddUserView();
				toMessage(10003,user);
				//Money money = View.AddMenoyView();
				//toMessage(10004,money);
			}
				break;
			case 2:
				//销户
			{
				String username = View.delUserView();
				toMessage(10005,username);
			}
				break;
			case 3:
				//导入xls
				toMessage(10006,null);
			    break;
			case 4:
				//导出xls
			{
				int number = View.DriveView();
				toMessage(10007,number);
			}
				break;
			case 5:
				//导出pdf
				toMessage(10008,null);
				break;
				
			}
			getMessage();
			service();
			}
	}
	//用户登陆后对应的窗口方法
	public static void ClientInterface(){
		while(true)
		{
			int i = View.userView();
			switch(i)
			{
			case 0:
				System.exit(0);
				break;
				//退出
			case 1:
				//查询余额
				View.FindUserView();
				toMessage(10010,username);
				break;
			case 2:
				//取钱
				Double balance = View.quView11();
				Money money=new Money();
				money.setbalance(balance);
				money.setusername(username);
				toMessage(10011,money);
				break;
			case 3:
				//存钱
				Double balance1 = View.cunView11();
				Money money1=new Money();
				money1.setbalance(balance1);
				money1.setusername(username);
				toMessage(10012,money1);
				break;
			case 4:
				//转账
				View.transView1();
				Double balance2 = View.transView11();
				Money money2=new Money();
				money2.setbalance(balance2);
				money2.setusername(username);
				toMessage(10013,money2);
				
				String username4 = View.transView2();
				Double balance3 = View.transView11();
				Money money3=new Money();
				money3.setbalance(balance3);
				money3.setusername(username4);
				toMessage(10014,money3);
				break;
				
			case 5:
				//修改账户密码信息	
				User oldUser = new User(username, null);
				User newUser = View.updateUserView(oldUser);
				toMessage(10016, new User[] { oldUser, newUser });
				break;
				
			case 6:
				//修改账户手机号码信息
				User oldUser1 = new User(username, null);
				User newUser1 = View.updateUserView_t(oldUser1);
				toMessage(10017, new User[] { oldUser1, newUser1 });
				break;
				
			}
			getMessage();
			service();
		}
	}
	
	/**
	 * 用于获取服务器发送消息中的类型，并进行分类处理
	 */
	private static void service() {
		Integer i = (Integer) getData.get("type");
		switch (i) {
		case 20004:
			// 管理员开户成功
			System.out.println("恭喜你, 开户成功了 ! ");
			break;
		case 20005:
			// 管理员开户失败
			System.out.println("很遗憾, 开户失败！");
			break;
		case 20006:
			// 管理员销户成功
			System.out.println("恭喜你, 销户成功 ! ");
			break;
		case 20007:
			// 管理员销户失败
			System.out.println("很遗憾, 销户失败 ！");
			break;
		case 20008:
			// 查询余额成功
			{
				double money1 = (Double) getData.get("data");
			 System.out.println("查询余额成功 ");
				System.out.println("账户余额:");
				System.out.println(money1);
			}
			break;
		case 20009:
			// 取钱成功
		{
			double money1 = (Double) getData.get("data");
			System.out.println("取钱成功");
			System.out.println("账户余额:");
			System.out.println(money1);
		}
		break;
		case 20010:
			// 取钱失败
			System.out.println("取钱失败");
			break;
		case 20011:
			//存钱成功
		{
			double money1 = (Double) getData.get("data");
			System.out.println("存钱成功");
			System.out.println("账户余额:");
			System.out.println(money1);
		}
			break;
		case 20019:
			// 存钱失败
			System.out.println("存钱失败");
			break;
		case 20012:
			// 转账成功
		{
			double money1 = (Double) getData.get("data");
			System.out.println("转账成功");
			System.out.println("账户余额:");
			System.out.println(money1);
		}
			break;
		case 20013:
			// 转账失败
			System.out.println("转账失败");
			break;
		case 20014:
			// 修改账户密码信息成功
			System.out.println("修改账户密码信息成功");
			break;
		case 20015:
			// 修改账户密码信息失败
			System.out.println("修改账户密码信息失败");
			break;
		case 20016:
			// 修改账户手机号码成功
			System.out.println("修改账户手机号码成功");
			break;
		case 20017:
			// 修改账户手机号码失败
			System.out.println("修改账户手机号码失败");
			break;
		case 20018:
			// 查询余额失败
			System.out.println("查询余额失败");
			break;
		case 20020:
			// 导出xls成功
			System.out.println("导出xls成功");
			break;
		case 20021:
			// 导出xls失败
			System.out.println("导出xls失败");
			break;
		case 20022:
			// 导入xls成功
			System.out.println("导入xls成功");
			break;
		case 20023:
			// 导入xls失败
			System.out.println("导入xls失败");
			break;
		case 20024:
			// 导出pdf成功
			System.out.println("导出pdf成功");
			break;
		case 20025:
			// 导出pdf失败
			System.out.println("导出pdf失败");
			break;
		default:
			break;
		}
	}
	/**
	 * 方法：用于向服务器发送消息
	 * 
	 * @param type
	 *            消息类型
	 * @param data
	 *            消息内容
	 */
	private static void toMessage(int type, Object data) {
		// 每次发的hashmap地址必须不同，因此需要创建一个新的对象
		toData = new HashMap<>();
		toData.put("type", type);
		toData.put("data", data);
		try {
			oos.writeObject(toData);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 方法:用于获取服务器发来的消息
	 */
	private static void getMessage() {
		try {
			getData = (HashMap<String, Object>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
/*
public class ExcelOpImpl implements ExcelOp {

    /*
    System.out.println("请输入文件路径");
    Scanner sc = System.in();
    String path = sc.next();
    List<User> userList = ExcelOpImpl.readUserinfo(path);
    System.out.println(userList);

    List<String> userListSelect = ExcelOpImpl.selectUserinfo(select);

    // 数据写入数据库
    UserService userService = new UserService();
    userService.save(userList);
     */
/*
    // 用于开户，所有用户送 2000 ，userinfo, moneyinfo 表都修改
    public static List<User> readUserinfo(String path) throws IOException {

        List<User> userList = new ArrayList<>();

        XSSFWorkbook xssfWorkbook =  new XSSFWorkbook(path);                            // 1.获取工作簿
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);                             // 2. 获取工作表 1

        int lastRowNum = sheet.getLastRowNum();
        for(int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);                                              // 获取每一行数据
            if(row != null) {
                List<String> list = new ArrayList<>();                                  // 每行一个 list
                for(Cell cell : row) {
                    if(cell != null) {
                        // cell.setCellType(Cell.CELL_TYRE_STRING);                     // 单元格格式都需要为 文本格式
                        String value = cell.getStringCellValue();
                        if(value != null)                                               // value 为空，空值也添加
                            list.add(value);
                    }
                }
                if(list.size() > 0) {
                    User user =  new User(Long.parseLong(list.get(0)), list.get(1), list.get(2),Long.parseLong(list.get(3)), Long.parseLong(list.get(4)), list.get(5), list.get(6));
                    userList.add(user);                                       // 以行为单位封装入 userList 中
                }
            }
        }
        return userList;
    }

    /**
     *  模糊查询用户信息
     *  可使用 ‘%a%’  '_a'(‘_’代表单个字符)
     * @param select 查询的内容
     * @param op 对 op 列进行查询 gender 不提供查询
     * @return
     * @throws IOException
     */
/*
    public static List<String> selectUserinfo(String select, String op) throws IOException, SQLException {
        UserService userService = new UserService();

        return userService.selectinfo(select, op);
    }

   */
