package lib.util;

import java.sql.*;

public class MySQLconnection {

    private static final String DBDRIVER = "com.mysql.cj.jdbc.driver";			            // MySQL 驱动
	private static final String DBURL = "jdbc:mysql://124.70.10.116/bankinfo";			    // MySQL URL
	private static final String DBUSER = "root";										    // MySQL 登录用户名
	private static final String DBPASSWORD = "diaoxianLZU123;"; 							// 登录密码
	public static Connection getConnection(){
		// 连接数据库
        Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			// System.out.println("11111");
		} catch (ClassNotFoundException e) {
			// System.out.println("222222");
			e.printStackTrace();										
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
        // 关闭 Connection
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
        // 关闭 PreparedStatement
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt) {
		// 关闭 Statement
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
 
	public static void close(ResultSet rs) {
        //关闭 ResultSet
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}