package com.qst.gptdrivingassistant.biz;

import com.qst.gptdrivingassistant.bean.AccountUser;

import java.sql.SQLException;
import java.util.List;

// 记帐用户业务访问接口
public interface AccountUserBiz {
   /**
    * 登录方法
    * @param userName 帐号
    * @param passWord 密码
    * @return 登录成功，则返回AccountUser实体，登录失败返回null
    */
   AccountUser login(String userName,String passWord);
   AccountUser register(String userName,String passWord);

   void userSetting(AccountUser user);

   List<AccountUser> getAllUserList() throws SQLException;

   void userDelete(int id);

   void adminUserSetting(AccountUser id);

   AccountUser getUser(int id) throws SQLException;
}
