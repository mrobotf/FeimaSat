package lib.bankOp;

import lib.bean.User;
import lib.util.DbcpJdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void save(User user) {
        String sql = "INSERT INTO userinfo VALUES (?,?,?,?,?,?,?)";
        try{
            Connection conn= DbcpJdbcUtil.getConnection();
            PreparedStatement psta = conn.prepareStatement(sql);
            // Statement stmt=conn.createStatement()

            psta.setString(1, user.getusername());
            psta.setLong(2, user.getuserID());
            psta.setLong(3, user.getid());
            psta.setLong(3, user.getid());
            psta.setString(4, user.getpassword());
            psta.setLong(5, user.getphone());
            psta.setString(6, user.getgender());
            psta.setDate(7, Date.valueOf(user.getbirthYYD()));

            int rs = psta.executeUpdate();   // 返回修改结果

            DbcpJdbcUtil.releaseUpdate(conn, psta);
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> selectinfo(String select, String op) throws SQLException {
        String sql = null;
        List<String> list = new ArrayList<>();

        switch (op){                                                                    // 判断对哪一列进行查询
            case "username":
                sql = "SELECT username FROM userinfo WHERE username LIKE ?";
            case "userid":
                sql = "SELECT userid FROM userinfo WHERE userid LIKE ?";
            case "id":
                sql = "SELECT id FROM userinfo WHERE id LIKE ?";
            case "password":
                sql = "SELECT password FROM userinfo WHERE password LIKE ?";
            case "phone":
                sql = "SELECT phone FROM userinfo WHERE phone LIKE ?";
            case "dob":
                sql = "SELECT userid FROM userinfo WHERE userid LIKE ?";
            default: list = null;
        }
        if(list.equals(null))                                                       // op 不符合规定，返回空 List
            return list;
        Connection conn= DbcpJdbcUtil.getConnection();
        PreparedStatement psta = conn.prepareStatement(sql);
        psta.setString(1, select);

        ResultSet rs = psta.executeQuery();                                             // 只返回 List?
        while(rs.next()) {
            list.add(rs.getString(op).toString());
        }
        return list;
    }
}

