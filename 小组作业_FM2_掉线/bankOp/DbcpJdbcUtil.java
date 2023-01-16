package lib.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbcpJdbcUtil {

    private static DataSource ds = null;
    static{
        try{
        InputStream in = DbcpJdbcUtil.class.getResourceAsStream("dbcp.properties");
        Properties prop = new Properties();
        prop.load(in);                                              //以上与1同
        ds = BasicDataSourceFactory.createDataSource(prop);  //工厂，创建Source
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

    // 使用 executeUpdate() 方法后释放
    public static void releaseUpdate(Connection conn,Statement st){
        if(st!=null){
            try{
            st.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            st=null;
        }
        if(conn!=null){
            try{
            conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            conn=null;
        }
    }

    // 使用 executeUpdate() 方法后释放
    public static void releaseQuery(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            rs=null;
        }
        if(st!=null){
            try{
                st.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            st=null;
        }
        if(conn!=null){
            try{
                conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            conn=null;
        }
    }
}