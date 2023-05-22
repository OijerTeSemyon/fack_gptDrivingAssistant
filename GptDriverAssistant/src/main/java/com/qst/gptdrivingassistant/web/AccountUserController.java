package com.qst.gptdrivingassistant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.qst.gptdrivingassistant.bean.AccountUser;
import com.qst.gptdrivingassistant.biz.AccountUserBiz;

//记帐用户Controller
public class AccountUserController extends MultiActionController {
	// Spring注入accountUserBizp实例
	AccountUserBiz accountUserBiz;

	public AccountUserBiz getAccountUserBiz() {
		return accountUserBiz;
	}

	public void setAccountUserBiz(AccountUserBiz accountUserBiz) {
		this.accountUserBiz = accountUserBiz;
	}

	// 跳转到登录 界面
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/login");
	}

	public ModelAndView toRegister(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/register");
	}

	// login.do 进行登录操作（传入帐号，密码）
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		AccountUser user = this.accountUserBiz.login(userName, passWord);
		if (user != null) {
			// 将登录成功的用户实例保存入Session
			request.getSession().setAttribute("user", user);
			return "redirect:mainView.do";
		} else {
			request.setAttribute("msg", "登录失败,帐号或密码错误！");
			return "/login";
		}
	}

	public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		AccountUser user = this.accountUserBiz.register(userName, passWord);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("msg", "注册成功！");
			return "/login";
		} else {
			request.setAttribute("msg", "注册失败,可能用户名重复！");
			return "/register";
		}

	}
	/**
	 * 注销
	 * 
	 * @return 返回view视图
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("/login");
	}

}
