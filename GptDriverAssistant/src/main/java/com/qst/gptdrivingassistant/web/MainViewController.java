package com.qst.gptdrivingassistant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.gptdrivingassistant.biz.MainViewBiz;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * ����/֧����¼��������
 */
public class MainViewController extends MultiActionController {
	// ע��recordBiz
	private MainViewBiz mainViewBiz;

	public MainViewBiz getMainViewBiz() {
		return mainViewBiz;
	}

	public void setMainViewBiz(MainViewBiz mainViewBiz) {
		this.mainViewBiz = mainViewBiz;
	}


	public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response) {
		// ���Session�д���msg,��ɾ��
		if (request.getSession().getAttribute("msg") != null)
			request.getSession().removeAttribute("msg");

		return new ModelAndView("/main");
	}

}
