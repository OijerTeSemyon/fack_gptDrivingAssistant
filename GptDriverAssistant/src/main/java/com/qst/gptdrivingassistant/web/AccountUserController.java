package com.qst.gptdrivingassistant.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.qst.gptdrivingassistant.bean.AccountUser;
import com.qst.gptdrivingassistant.biz.AccountUserBiz;

//�����û�Controller
public class AccountUserController extends MultiActionController {
	// Springע��accountUserBizpʵ��
	AccountUserBiz accountUserBiz;

	public AccountUserBiz getAccountUserBiz() {
		return accountUserBiz;
	}

	public void setAccountUserBiz(AccountUserBiz accountUserBiz) {
		this.accountUserBiz = accountUserBiz;
	}

	// ��ת����¼ ����
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/login");
	}

	public ModelAndView toRegister(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/register");
	}

	// login.do ���е�¼�����������ʺţ����룩
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		AccountUser user = this.accountUserBiz.login(userName, passWord);
		if (user != null) {
			// ����¼�ɹ����û�ʵ��������Session
			request.getSession().setAttribute("user", user);
			return "redirect:mainView.do";
		} else {
			request.setAttribute("msg", "��¼ʧ��,�ʺŻ��������");
			return "/login";
		}
	}

	public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		AccountUser user = this.accountUserBiz.register(userName, passWord);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("msg", "ע��ɹ���");
			return "/login";
		} else {
			request.setAttribute("msg", "ע��ʧ��,�����û����ظ���");
			return "/register";
		}

	}
	/**
	 * ע��
	 * 
	 * @return ����view��ͼ
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("/login");
	}

}
