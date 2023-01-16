package lib.mysql;

import java.sql.SQLException;

import bean.Money;
import bean.User;

public interface MySQLimpl{
    /**
     * 判断用户是否存在、密码是否正确
     * @param user
     * @return 1 用户名、密码均正确     0 错误
     */
    abstract int login(User user);

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    // abstract boolean userSelect(String username);

    /**
     * 依据 username 查询余额
     * @param username 被查询用户
     * @return
     */
    abstract double moneySelect(String usename);
    
    /**
     * 开户
     * @param user
     * @return false 操作失败
     */
    abstract boolean insert(User user);
    
    /**
     * 减少用户余额
     * @param username 要修改的用户名  balance 最终修改的余额
     * @return true 修改成功
     */
    abstract boolean moneyDed(Money mon);

    /**
     * 增加用户余额
     * @param mon  username 要修改的用户名  balance 最终修改的余额
     * @return true 修改成功
     */
    abstract boolean moneyAdd(Money mon);
    
    /**
     * 销户
     * @param username
     * @return
     */
    abstract boolean delete(String username);
    
    /**
     * userinfo 表修改 String 类型数据(密码)
     * @param user1 旧密码
     * @param user2 新密码
     * @param op 将要执行的操作类型
     * @return
     */
    abstract boolean userUpdateString(User user1, User user2);

    /**
     * userinfo 表修改 Long 类型数据(手机号)
     * @param user1 旧信息
     * @param user2 新信息
     * @return
     */
    abstract boolean userUpdateLong(User user1, User user2);
    
}