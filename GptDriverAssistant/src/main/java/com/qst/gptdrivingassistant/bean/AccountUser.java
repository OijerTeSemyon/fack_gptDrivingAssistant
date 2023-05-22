package com.qst.gptdrivingassistant.bean;

/**
 * 记帐用户实体类
 */
public class AccountUser {
	private Integer userId; // 用户ID
	private String userName; // 用户名称
	private String passWord; // 用户密码
	private Integer userType; // 用户类型,0：普通用户，1：管理员
	private String userDesc; // 用户描述

	private String apiKey;

	private String apiSecret;

	private int ifOverSpeedWarn;

	private String imageLocation;

	public AccountUser() {

	}

	public AccountUser(Integer userId, String userName, String passWord, Integer userType, String userDesc,String apiKey,String apiSecret,int ifOverSpeedWarn,String imageLocation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.userType = userType;
		this.userDesc = userDesc;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.ifOverSpeedWarn = ifOverSpeedWarn;
		this.imageLocation = imageLocation;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiSecret(String apiSerect) {
		this.apiSecret = apiSerect;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public int getIfOverSpeedWarn() {
		return ifOverSpeedWarn;
	}

	public void setIfOverSpeedWarn(int ifOverSpeedWarn) {
		this.ifOverSpeedWarn = ifOverSpeedWarn;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
}
