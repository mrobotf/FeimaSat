package lib.bankOp;

import lib.bean.Money;
import lib.util.DbcpJdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyDao {
    /**
     * 向 moneyinfo 表导入数据
     * @param money
     */
    public void save(Money money) {
        String sql = "INSERT INTO moneyinfo VALUES (?,?)";
        try{
            Connection conn= DbcpJdbcUtil.getConnection();
            PreparedStatement psta = conn.prepareStatement(sql);
            // Statement stmt=conn.createStatement()

            psta.setString(1, money.getusername());
            psta.setDouble(2, money.getbalance());

            int rs = psta.executeUpdate();   // 返回修改结果

            DbcpJdbcUtil.releaseUpdate(conn, psta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
