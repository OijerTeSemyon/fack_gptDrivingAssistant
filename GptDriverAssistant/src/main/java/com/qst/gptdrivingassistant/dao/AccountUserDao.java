package com.qst.gptdrivingassistant.dao;

import java.sql.SQLException;
import java.util.List;

import com.qst.gptdrivingassistant.bean.AccountUser;
// �����û����ݷ��ʽӿ�
public interface AccountUserDao {
    /**
     * �����û����ƻ�ȡ�û�ʵ��
     * @param userName �û�����
     * @return �û�ʵ����ʵ��
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
