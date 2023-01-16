package lib.mysql;

import lib.util.*;
import lib.mysql.*;
import java.sql.*;

import bean.Money;
import bean.User;

public class MySQLmanage implements MySQLimpl{

    public int login(User user) {
        Connection con = null;
        ResultSet rs = null;
        String username_m = user.getusername();        
        String sql = "SELECT username, password FROM userinfo WHERE username = ? ";
        try {
            con = MySQLconnection.getConnection();
            if(!con.isClosed())
                System.out.println("成功连接数据库");
            
            PreparedStatement psta = con.prepareStatement(sql);
            psta.setString(1, username_m);
            rs = psta.executeQuery();
            
            if(rs != null) {                                       // 判断用户名是否正确
                rs.next();
                String name = rs.getString("username");
                String pw = rs.getString("password");
                if(name.equals(username_m) && pw.equals(user.getpassword())) {
                    System.out.println(name+pw);
                    psta.close();
                    con.close();
                    return 1;
                } else return 0;
            } else{
                psta.close();
                con.close();
                return 0;             
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double moneySelect(String username) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement psta = null;
        String sql = "SELECT balance FROM moneyinfo WHERE username = ?";
        try {
            con  = MySQLconnection.getConnection();
            if(!con.isClosed())
                System.out.println("成功连接数据库");

            psta = con.prepareStatement(sql);
            psta.setString(1, username);
            rs = psta.executeQuery();
            
            if(rs != null) {
                rs.next();
                double bal = rs.getDouble("balance");         // bal == 0, no balance.
                System.out.println(bal);
                psta.close();
                con.close();
                return bal;  // 存在该用户
            }
            else {
                psta.close();
                con.close();
                return -1.0;                                  // the query fails
            }

        } catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean insert(User user) {
        Connection con = null;
        int rs = -1;
        PreparedStatement psta = null;
        String sql = "INSERT INTO userinfo (username, userid, id, password, phone, gender, dob) VALUES(?,?,?,?,?,?,?)";
        
        try {
            con  = MySQLconnection.getConnection();
            if(!con.isClosed())
            System.out.println("成功连接数据库");
            
            String username = user.getusername();
            long userid = user.getuserID();
            long id = user.getid();
            String password = user.getpassword();
            long phone = user.getphone();
            String gender = user.getgender();
            String dob = user.getbirthYYD();                                            // 格式  yyyy-[m]m-[d]d

            psta = con.prepareStatement(sql);
            psta.setString(1, username);
            psta.setLong(2, userid);
            psta.setLong(3, id);
            psta.setString(4, password);
            psta.setLong(5, phone);
            psta.setString(6, gender);
            psta.setDate(7, Date.valueOf(dob));
            rs = psta.executeUpdate();
            
            sql = "INSERT INTO moneyinfo (username, balance) VALUES(?, ?)";             // 对 moneyinfo 表进行修改，开户送 2000 元
            psta = con.prepareStatement(sql);
            psta.setString(1, username);
            psta.setDouble(2, 2000);
            rs = psta.executeUpdate();
            
            psta.close();
            con.close();
            if(rs != -1)
                return true;                                                            // 成功开户
            else
                return false;
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean moneyDed(Money mon) {
        Connection con = null;
        ResultSet rs_sel = null;
        int rs = -1;
        PreparedStatement psta = null;
        String sql_sel = "SELECT balance FROM moneyinfo WHERE username = ?";
        String sql = "UPDATE moneyinfo SET balance = ? WHERE username = ?";

        try {
            con = MySQLconnection.getConnection();
            if(!con.isClosed())
                System.out.println("成功连接数据库");

            String username = mon.getusername();
            double bal = mon.getbalance();

            psta = con.prepareStatement(sql_sel);                                       // 判断余额是否为 0，余额为 0，则不能修改
            psta.setString(1, username);
            rs_sel = psta.executeQuery();
            if(rs_sel != null) {
                rs_sel.next();
                double temp = rs_sel.getDouble("balance");
                if(temp == 0) {
                    System.out.println("余额为 0 ");
                    return false;
                }
            }

            psta = con.prepareStatement(sql);
            psta.setDouble(1, bal);
            psta.setString(2, username);
            rs = psta.executeUpdate();
            psta.close();
            con.close();

            if(rs != -1) {
                return true;                                                            // 修改成功
            } else return false;

        } catch(Exception e) {
            // System.out.println("操作失败");
            e.printStackTrace();
            return false;
        }
    }

    public boolean moneyAdd(Money mon){
        Connection con = null;
        // ResultSet rs_sel = null;
        int rs = -1;
        PreparedStatement psta = null;
        // String sql_sel = "SELECT balance FROM moneyinfo WHERE username = ?";
        String sql = "UPDATE moneyinfo SET balance = ? WHERE username = ?";

        try {
        	con = MySQLconnection.getConnection();
        if(!con.isClosed())
            System.out.println("成功连接数据库");

        String username = mon.getusername();
        double bal = mon.getbalance();

        psta = con.prepareStatement(sql);
        psta.setDouble(1, bal);
        psta.setString(2, username);
        rs = psta.executeUpdate();
        psta.close();
        con.close();

        	if(rs != -1) {
            	return true;                                                                // 成功修改
        	} else {
            	return false;
        	}
        } catch(Exception e) {
        	e.printStackTrace();
        }
		return false;
    }

    public boolean delete(String username) {
        Connection con = null;
        int rs = -1;
        PreparedStatement psta = null;
        String sql = "DELETE FROM userinfo WHERE username = ?";

        try {
            con = MySQLconnection.getConnection();
            if(!con.isClosed())
                System.out.println("成功连接数据库");

            psta = con.prepareStatement(sql);
            psta.setString(1, username);
            rs = psta.executeUpdate();

            sql = "DELETE FROM moneyinfo WHERE username = ?";            
            psta = con.prepareStatement(sql);
            psta.setString(1, username);
            rs = psta.executeUpdate();
            psta.close();
            con.close();

            if(rs != -1) {
                return true;                                                            // 成功删除
            } else return false;

        } catch(Exception e) {
            System.out.println("操作失败");
            e.printStackTrace();
            return false;
        }    
    }

    public boolean userUpdateString(User userO, User userN){
        Connection con = null;
        PreparedStatement psta = null;
        int rs = -1;
        String sql = "UPDATE userinfo SET password = ? WHERE username = ? ";
        try {
            con = MySQLconnection.getConnection();
            psta = con.prepareStatement(sql);
            psta.setString(1, userN.getpassword());
            psta.setString(2, userO.getusername());
            rs = psta.executeUpdate();
            psta.close();
            con.close();

            if(rs != -1) {
                return true;                                    // 修改成功
            } else {
                return false;
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean userUpdateLong(User userO, User userN) {
        Connection con = null;
        PreparedStatement psta = null;
        int rs = -1;
        String sql = "UPDATE userinfo SET phone = ? WHERE username = ?";
        try {
            con = MySQLconnection.getConnection();
            psta = con.prepareStatement(sql);
            psta.setLong(1, userN.getphone());
            psta.setString(2, userO.getusername());
            rs = psta.executeUpdate();
            con.close();
            psta.close();

            if(rs != -1) {
                return true;                                                            // 修改成功
            } else {
                return false;                                                           // 修改失败
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}