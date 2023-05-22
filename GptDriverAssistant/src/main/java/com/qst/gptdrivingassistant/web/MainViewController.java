package com.qst.gptdrivingassistant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.gptdrivingassistant.biz.MainViewBiz;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 收入/支出记录控制器类
 */
public class MainViewController extends MultiActionController {
	// 注入recordBiz
	private MainViewBiz mainViewBiz;

	public MainViewBiz getMainViewBiz() {
		return mainViewBiz;
	}

	public void setMainViewBiz(MainViewBiz mainViewBiz) {
		this.mainViewBiz = mainViewBiz;
	}


	public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response) {
		// 如果Session中存在msg,则删除
		if (request.getSession().getAttribute("msg") != null)
			request.getSession().removeAttribute("msg");

		return new ModelAndView("/main");
	}

}
