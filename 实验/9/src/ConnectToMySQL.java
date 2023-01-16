import java.sql.*;
public class ConnectToMySQL {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://116.63.159.135:3306/lzu2021students";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "12345678qQ";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            Statement sql = con.createStatement();
            String querystatement = "SELECT * FROM stu";
            ResultSet result = sql.executeQuery(querystatement);

            System.out.println("\tStu 表数据如下：");
            System.out.println("---------------------------------");
            System.out.println("学  号\t" + "姓  名\t" + "年龄\t" + "成  绩");
            System.out.println("---------------------------------");
            String stu_id;
            String stu_name;
            int stu_age;
            float stu_score;

            while (result.next()) {
                stu_id = result.getString("Stu_id");
                stu_name = result.getString("Stu_name");
                stu_age = result.getInt("Stu_age");
                stu_score = result.getFloat("Stu-score");
                System.out.println(stu_id + "\t" + stu_name + "\t" + stu_age + "\t" + stu_score);
            }
            sql.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
