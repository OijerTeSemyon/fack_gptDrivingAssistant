package com.qst.gptdrivingassistant.bizimpl;

import java.sql.SQLException;
import java.util.List;

import com.qst.gptdrivingassistant.bean.AccountUser;
import com.qst.gptdrivingassistant.biz.AccountUserBiz;
import com.qst.gptdrivingassistant.dao.AccountUserDao;

public class AccountUserBizImpl implements AccountUserBiz{
	//Spring 注入accountUserDao实体
    private AccountUserDao accountUserDao; 
    
	public AccountUserDao getAccountUserDao() {
		return accountUserDao;
	}

	public void setAccountUserDao(AccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}
    
	public AccountUser login(String userName, String passWord) {
		AccountUser user = null;
		try {
			user = this.accountUserDao.getAccountUser(userName);
			if (user==null) return null;
			if (!user.getPassWord().equals(passWord)) return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	//200107121022实现的注册方法
	public AccountUser register(String userName, String passWord) {
    	AccountUser user = new AccountUser();
    	try {
			user.setUserName(userName);
        	user.setPassWord(passWord);
        	if (this.accountUserDao.checkAccountUser(userName))
				user = null;
			else
				user = this.accountUserDao.insertAccountUser(user);
    	} catch (SQLException e) {
        	e.printStackTrace();
    	}

    	return user;
}

	@Override
	public void userSetting(AccountUser user) {
		try{
			this.accountUserDao.setUser(user);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public List<AccountUser> getAllUserList() throws SQLException {

		return this.accountUserDao.getAllUser();
	}

	@Override
	public void userDelete(int id) {
		this.accountUserDao.userDel(id);
	}

	@Override
	public void adminUserSetting(AccountUser user) {
		this.accountUserDao.adminUserSet(user);
	}

	@Override
	public AccountUser getUser(int id) throws SQLException {
		return this.accountUserDao.getAccountUserById(id);
	}


}
