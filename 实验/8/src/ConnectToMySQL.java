import java.sql.*;

public class ConnectToMySQL {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");      // 加载驱动
        String userName = "root";
        String password = "12345678q";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            Statement sql = con.createStatement();
            sql.execute("DROP TABLE IF EXISTS student");
            sql.execute("CREATE TABLE student(" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(20) NOT NULL default 'name'," +
                    "math INT not null default 60," +
                    "PRIMARY KEY(id))");
            sql.execute("INSERT student VALUES(1, 'AAA', '99')");
            sql.execute("INSERT student VALUES(2, 'BBB', '77')");
            sql.execute("INSERT student VALUES(3, 'CCC', '65')");
            String query = "SELECT * FROM student";
            ResultSet result = sql.executeQuery(query);
            System.out.println("Student 表数据如下：");
            System.out.println("------------------------------------");
            System.out.println("学号" + " " + "姓名" + " " + "数学成绩");
            System.out.println("------------------------------------");
            int number;
            String name;
            String math;
            while(result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            sql.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("SQLException:" + ex.getMessage());
        } catch (java.lang.ClassNotFoundException ex) {
            System.out.println("SQLException:" + ex.getMessage());
        }
    }
}
