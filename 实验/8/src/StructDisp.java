import java.io.*;
import java.sql.*;

public class StructDisp {
    static String colLabel[];
    static int colCount;

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678q");
            Statement stmt = con.createStatement();     // 创建语句对象
            boolean status = stmt.execute("SELECT * FROM student");
            ResultSet rs = stmt.getResultSet();
            showStruct(rs);
            showData(rs);
            stmt.close();
            con.close();    // 关闭链接
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    private static void showData(ResultSet rs) throws SQLException {
        if(rs != null) {
            while(rs.next()) {   // 遍历记录集
                System.out.print("" + rs.getString(colLabel[1]));
                System.out.print("\t" + rs.getString(colLabel[2]));
                System.out.print("\t" + rs.getInt(colLabel[3]) + "\n");
            }
        }
        System.out.println("================================");
    }

    public static void showStruct(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        colCount = md.getColumnCount();
        colLabel = new String[colCount + 1];
        System.out.println("================================");
        for(int i = 1; i <= colCount; i++) {
            colLabel[i] = md.getColumnLabel(i);
            System.out.print("" + colLabel[i] + "\t");
        }
        System.out.println("\n==============================");
    }
}
