package com.qst.gptdrivingassistant.dao;

import java.sql.SQLException;
import java.util.List;

import com.qst.gptdrivingassistant.bean.AccountUser;
// 记帐用户数据访问接口
public interface AccountUserDao {
    /**
     * 根据用户名称获取用户实体
     * @param userName 用户名称
     * @return 用户实体类实例
     */
    AccountUser getAccountUser(String userName) throws SQLException;

    AccountUser insertAccountUser(AccountUser user) throws SQLException;

    boolean checkAccountUser(String userName) throws SQLException;

    void setUser(AccountUser user) throws SQLException;

    List<AccountUser> getAllUser() throws SQLException;

    void userDel(Integer id);

    void adminUserSet(AccountUser id);

    AccountUser getAccountUserById(int id) throws SQLException;
}
