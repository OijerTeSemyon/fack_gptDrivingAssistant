package com.qst.gptdrivingassistant.bizimpl;

import java.sql.SQLException;
import java.util.List;

import com.qst.gptdrivingassistant.bean.MainView;
import com.qst.gptdrivingassistant.biz.MainViewBiz;
import com.qst.gptdrivingassistant.dao.AccountUserDao;
import com.qst.gptdrivingassistant.dao.MainViewDao;

/**
 * ��֧��¼ҵ�������
 *
 */
public class MainViewBizImpl implements MainViewBiz {


	private MainViewDao mainViewDao;

	public MainViewDao getRecordDao() {
		return mainViewDao;
	}

	public void setMainViewDao(MainViewDao mainViewDao) {
		this.mainViewDao = mainViewDao;
	}
}
