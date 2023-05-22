package com.qst.gptdrivingassistant.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.qst.gptdrivingassistant.bean.AccountUser;
import com.qst.gptdrivingassistant.dao.AccountUserDao;
//记帐用户数据访问接口实现类
public class AccountUserDaoImpl implements AccountUserDao {
	//用于注入的DataSource实例
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	//根据用户姓名获取实体信息
	public AccountUser getAccountUser(String userName) throws SQLException {
		Connection conn = null;
		AccountUser user = null;
		try {
			conn = dataSource.getConnection();

			String sql = "select userId,userDesc,userName,passWord,userType,apiKey,apiSecret,ifOverSpeedWarn,imageLocation from user where userName='"+userName+"'";
			Statement smt = conn.createStatement();
			System.out.println();
			System.out.println(sql);
			System.out.println();
			ResultSet rs = smt.executeQuery(sql);

			if  (rs.next()) {
				Integer uid = rs.getInt("userId");
				String uName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				Integer userType = rs.getInt("userType");
				String userDesc = rs.getString("userDesc");
				String apiKey = rs.getString("apiKey");
				String apiSecret = rs.getString("apiSecret");
				int ifOverSpeedWarn = rs.getInt("ifOverSpeedWarn");
				String imageLocation = rs.getString("imageLocation");
			    user = new AccountUser(uid, uName, passWord, userType, userDesc,apiKey,apiSecret,ifOverSpeedWarn,imageLocation);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return user;
	}




	@Override
	public AccountUser insertAccountUser(AccountUser user) throws SQLException {
		String userName = user.getUserName();
		String password = user.getPassWord();
		try (Connection conn = dataSource.getConnection()) {
			String sql = "insert into user(userName,passWord,userDesc) values(\"" + userName + "\",\"" + password + "\",\"普通用户\")";
			System.out.println(sql);
			Statement smt = conn.createStatement();
			smt.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}


	@Override
	public boolean checkAccountUser(String userName) throws SQLException {
		Connection conn = null;
		AccountUser user = null;
		String uName = null;
		conn = dataSource.getConnection();
		String sql = "select userName from user where userName=\""+ userName+"\"";
		Statement smt = conn.createStatement();
		ResultSet rs = smt.executeQuery(sql);
		if (rs.next()) {
			uName = rs.getString("userName");
		}
		return uName != null;
	}

	@Override
	public void setUser(AccountUser user) throws SQLException {
		try (Connection conn = dataSource.getConnection()) {
			String userName = user.getUserName();
			String passWord = user.getPassWord();
			String apiKey = user.getApiKey();
			String apiSecret = user.getApiSecret();
			String imageLocation = user.getImageLocation();
			String sql = "update user set passWord = \"" + passWord + "\",apiKey = \"" + apiKey + "\",apiSecret = \"" + apiSecret + "\",imageLocation = \"" + imageLocation + " \" where userName = \"" + userName +"\"";
			System.out.println();
			System.out.println(sql);
			System.out.println();
			Statement smt = conn.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<AccountUser> getAllUser() throws SQLException {
		Connection conn = null;
		List<AccountUser> userList = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String sql = "select userId,userName,apiKey,apiSecret from user";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {

				Integer userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String userApiKey = rs.getString("apiKey");
				String userApiSecret = rs.getString("apiSecret");

				AccountUser user = new AccountUser(userId,userName,"",0,"普通用户",userApiKey,userApiSecret,0,"");
				userList.add(user);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return userList;
	}

	@Override
	public void userDel(Integer id) {
		try (Connection conn = dataSource.getConnection()) {
			String sql = "delete from user where userId = \"" + id.toString() +"\"" ;
			System.out.println();
			System.out.println(sql);
			System.out.println();
			Statement smt = conn.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void adminUserSet(AccountUser user) {
		try (Connection conn = dataSource.getConnection()) {
			Integer userId = user.getUserId();
			String userName = user.getUserName();
			String apiKey = user.getApiKey();
			String apiSecret = user.getApiSecret();
			String sql = "update user set apiKey = \"" + apiKey + "\",apiSecret = \"" + apiSecret + "\" " + "where userId = \"" + userId +"\"";
			System.out.println();
			System.out.println(sql);
			System.out.println();
			Statement smt = conn.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountUser getAccountUserById(int userId) throws SQLException {
		Connection conn = null;
		AccountUser user = null;
		try {
			conn = dataSource.getConnection();

			String sql = "select userName,passWord,userType,apiKey,apiSecret,ifOverSpeedWarn from user where userId='"+userId+"'";
			Statement smt = conn.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			if  (rs.next()) {
				String uName = rs.getString("userName");
				String apiKey = rs.getString("apiKey");
				String apiSecret = rs.getString("apiSecret");
				int ifOverSpeedWarn = rs.getInt("ifOverSpeedWarn");
			    user = new AccountUser(userId, uName, "", 0, "",apiKey,apiSecret,ifOverSpeedWarn,"");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}
		return user;
	}


}
