import java.util.*;
import java.io.*;

/**
 * 说明：所有的英文输入大小写不敏感
 * 
 * 游戏开始时从文件名为 “SatInfo.txt” 文件中读取数据，按 “9” 退出游戏后，数据存入文件中
 * 
 * 卫星相关操作由 Satellite 类提供
 * 初始化、显示、查找、检查 功能由 CheckOut 类提供
 * 
 * 卫星信息：卫星ID(COSPARID)、卫星名称(name)、卫星轨道半径(orbit)、卫星状态(avl)
 * 4 个 ArrayList 分别存储
 * 
 */

public class Main {
    public static void main(String[] args) throws IOException{

        StringBuffer menuList = new StringBuffer("")
                .append("***********************************\n")
                .append("     1---显示当前活动卫星列表\n")
                .append("     2---显示停运卫星列表\n")
                .append("     3---注册新卫星\n")
                .append("     4---删除旧卫星\n")
                .append("     5---激活卫星\n")
                .append("     6---封锁卫星\n")
                .append("     7---按名称模糊查找卫星\n")
                .append("     8---修改卫星信息\n")
                .append("     9---退出!\n")
                .append("***********************************\n")
                .append("请输入 1-9 的数字\n")
                .append("选择: ");
    
        Scanner opIn = new Scanner(System.in);
        
        CheckOut Sat = new CheckOut();
        Satellite SatChange = new Satellite();
        String file = "SatInfo.txt";

        // 存储卫星数据
        ArrayList<String> satID = new ArrayList<String>();
        ArrayList<String> satName = new ArrayList<String>();
        ArrayList<Double> satOrbit = new ArrayList<Double>();
        ArrayList<Boolean> satAvl = new ArrayList<Boolean>();
        
        // 载入初始数据         
        CheckOut.ReadData(file, satID, satName, satOrbit, satAvl);

        String option;
        do {
            System.out.println(menuList);
            option = opIn.nextLine();

            // 检查非法输入
            while(option.isEmpty() || !(Integer.parseInt(option) < 10 || Integer.parseInt(option) > 0) || option.matches(".*[^0-9].*")) {
                System.out.println("非法，请重新输入：");
                option = opIn.nextLine();
            }

            switch (Integer.parseInt(option)) {
                case 1:
                    // 显示当前卫星列表
                    System.out.println("===============================================");
                    System.out.println("COSPARID            卫星名称   轨道半径   状态");
                    Sat.CurrentSat(satID, satName, satOrbit, satAvl);
                    System.out.println("===============================================\n");
                    break;
                case 2:
                    // 显示休眠卫星列表
                    System.out.println("===============================================");
                    System.out.println("COSPARID            卫星名称   轨道半径");
                    Sat.DormSat(satID, satName, satOrbit, satAvl);
                    System.out.println("===============================================\n");
                    break;
                case 3:
                    // 注册新卫星
                    SatChange.SignupSat(satID, satName, satOrbit, satAvl);
                    break;
                case 4:
                    // 删除旧卫星
                    SatChange.DelSat(satID, satName, satOrbit, satAvl);
                    break;
                case 5:
                    // 激活卫星
                    SatChange.ActivateSat(satID, satName, satOrbit, satAvl);
                    break;
                case 6:
                    // 封锁卫星
                    SatChange.LockSat(satID, satName, satOrbit, satAvl);
                    break;
                case 7:
                    // 名称模糊查找卫星
                    System.out.println("输入要查找的卫星名称：");
                    Sat.search(satID, satName, satOrbit, satAvl);
                    break;
                case 8:
                    // 修改卫星信息
                    SatChange.setSat(satID, satName, satOrbit, satAvl);
                    break;
                default:
                    break;
            }

        } while( Integer.parseInt(option) != 9);

        // 关闭 opIn
        opIn.close();

        // 数据存入文件中
        CheckOut.WriterData(file, satID, satName, satOrbit, satAvl);
        // CheckOut.ReadData(file, satID, satName, satOrbit, satAvl);

        System.exit(0);
    }
}