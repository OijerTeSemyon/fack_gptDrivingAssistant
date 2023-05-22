package com.qst.gptdrivingassistant.biz;

import com.qst.gptdrivingassistant.bean.AccountUser;

import java.sql.SQLException;
import java.util.List;

// �����û�ҵ����ʽӿ�
public interface AccountUserBiz {
   /**
    * ��¼����
    * @param userName �ʺ�
    * @param passWord ����
    * @return ��¼�ɹ����򷵻�AccountUserʵ�壬��¼ʧ�ܷ���null
    */
   AccountUser login(String userName,String passWord);
   AccountUser register(String userName,String passWord);

   void userSetting(AccountUser user);

   List<AccountUser> getAllUserList() throws SQLException;

   void userDelete(int id);

   void adminUserSetting(AccountUser id);

   AccountUser getUser(int id) throws SQLException;
}
