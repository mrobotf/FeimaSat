package lib.bankOp;

import lib.bean.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcelOpImpl{

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

    // 用于开户，所有用户送 2000 ，userinfo, moneyinfo 表都修改
    /**
     * 读取 excel 中 userinfo 数据
     * @return List<user>
     */
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
                        String value = cell.getStringCellValue();
                        if(value != null)                              // cell.setCellType(Cell.CELL_TYRE_STRING);                     // 单元格格式都需要为 文本格式
                            // value 为空，空值也添加
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
    public static List<String> selectUserinfo(String select, String op) throws IOException, SQLException {
        UserService userService = new UserService();

        return userService.selectinfo(select, op);
    }

    /**
     * 模糊查询信息写入xls文件
     * @param stringList 查询结果
     * @param path 文件保存路径
     */
    public static void writeSelect(List<String> stringList, String path) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();                                   // 创建工作簿
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("用户信息");                     // 创建工作表
        XSSFRow row = xssfSheet.createRow(0);                                     // 创建行
        row.createCell(0).setCellValue("result");                            // 创建第一行

        for (int i = 0; i < stringList.size(); i++) {
            XSSFRow row1 = xssfSheet.createRow(i+1);
            row1.createCell(0).setCellValue(stringList.get(i));
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        xssfWorkbook.close();
    }
}
