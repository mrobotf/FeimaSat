package lib.bankOp;

import lib.bean.User;
import lib.mysql.MySQLmanage;
import lib.util.DbcpJdbcUtil;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class UserService{

    public void save(List<User> userList) {
        MySQLmanage mySQLmanage = new MySQLmanage();
        // UserDao userdao = new UserDao();
        for (User user : userList) {
            mySQLmanage.insert(user);
        }
    }

    public List<String> selectinfo(String select, String op) throws SQLException {
        UserDao userdao = new UserDao();

        return userdao.selectinfo(select, op);
    }
}