package com.qst.gptdrivingassistant.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.qst.gptdrivingassistant.bean.MainView;
import com.qst.gptdrivingassistant.dao.MainViewDao;

/**
 * �û���֧��¼���ݷ�����
 */
public class MainViewDaoImpl implements MainViewDao {
    // ע��DataSource��ʵ��
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	

}
