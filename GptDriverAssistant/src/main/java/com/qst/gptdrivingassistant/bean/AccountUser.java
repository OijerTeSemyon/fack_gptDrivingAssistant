package com.qst.gptdrivingassistant.bean;

/**
 * �����û�ʵ����
 */
public class AccountUser {
	private Integer userId; // �û�ID
	private String userName; // �û�����
	private String passWord; // �û�����
	private Integer userType; // �û�����,0����ͨ�û���1������Ա
	private String userDesc; // �û�����

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
