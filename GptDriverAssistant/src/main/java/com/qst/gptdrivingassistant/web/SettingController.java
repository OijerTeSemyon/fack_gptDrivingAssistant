package com.qst.gptdrivingassistant.web;

import com.qst.gptdrivingassistant.bean.AccountUser;
import com.qst.gptdrivingassistant.biz.AccountUserBiz;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Controller
public class SettingController extends MultiActionController {
	// Spring注入accountUserBiz实例
	AccountUserBiz accountUserBiz;

	public AccountUserBiz getAccountUserBiz() {
		return accountUserBiz;
	}

	public void setAccountUserBiz(AccountUserBiz accountUserBiz) {
		this.accountUserBiz = accountUserBiz;
	}

	public ModelAndView toUserSetting(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/userSetting");
	}

	public ModelAndView toSpeedWarn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/speedWarn");
	}

	public ModelAndView toEnt(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		AccountUser user = null;
		user = (AccountUser) request.getSession().getAttribute("user");
		if (user.getUserName().equals("admin")) {
			List<AccountUser> users = accountUserBiz.getAllUserList();
			try {
				request.setAttribute("users", users);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("/ent", "users", users);
		} else {
			request.setAttribute("msg", "Admin only!");
			return new ModelAndView("/main");
		}
	}

	public ModelAndView toVoice(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/voice");
	}

	public String userSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountUser user;
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String apiKey = request.getParameter("apiKey");
		String apiSecret = request.getParameter("apiSecret");
		user = (AccountUser) request.getSession().getAttribute("user");

		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setApiKey(apiKey);
		user.setApiSecret(apiSecret);

		this.accountUserBiz.userSetting(user);
		return "redirect:mainView.do";
	}





	@RequestMapping("/getUpLoadImage")
	public String getUpLoadImage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("upLoading...");
		String fileName = "";
		// 使用fileupload组件完成文件上传
		// 上传的位置
		String path = request.getSession().getServletContext().getRealPath("/uploads/");

		// 判断，该路径是否存在
		File file = new File(path);
		if (!file.exists()) {
			// 创建该文件夹
			file.mkdirs();
		}

		// 解析request对象，获取上传文件项
		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 解析request
		List<FileItem> items = upload.parseRequest(request);

		// 遍历
		for (FileItem item : items) {
			// 进行判断，当前item对象是否是上传文件项
			if (item.isFormField()) {

				System.out.println("*说明普通表单向*");
				// 说明普通表单向
			} else {
				// 说明上传文件项
				// 获取上传文件的名称
				fileName = item.getName();
				// 把文件的名称设置唯一值，uuid
				String uuid = UUID.randomUUID().toString().replace("-", "");
				fileName = uuid + "_" + fileName;

				// 完成文件上传
				item.write(new File(path, fileName));
				// 删除临时文件
				item.delete();
			}
		}
		//String filePath = String.valueOf(path + fileName).replace("\\", "\\\\"); // 请替换为实际的文件路径和文件名
    	AccountUser user = (AccountUser) request.getSession().getAttribute("user");
    	user.setImageLocation(fileName);
    	this.accountUserBiz.userSetting(user);
		return "redirect:toUserSetting.do";
	}


	public String speedWarn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountUser user = null;
		user = (AccountUser) request.getSession().getAttribute("user");
		return "redirect:mainView.do";
	}

	public ModelAndView ent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<AccountUser> users = accountUserBiz.getAllUserList();
		try {

			request.setAttribute("users", users);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("/toEnt", "users", users);

	}

	public String voice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountUser user = null;

		user = (AccountUser) request.getSession().getAttribute("user");

		return "redirect:mainView.do";
	}

	public String userDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		if (id != 1)
			this.accountUserBiz.userDelete(id);
		else {
			request.setAttribute("msg", "Admin cant be deleted!");
		}
		return "redirect:mainView.do";
	}

	public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		AccountUser user = this.accountUserBiz.getUser(id);
		return new ModelAndView("/adminUserSetting","user",user);
	}

	public String adminUserSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("userId"));
		AccountUser user = this.accountUserBiz.getUser(id);
		String apiKey = request.getParameter("apiKey");
		String apiSecret = request.getParameter("apiSecret");
		user.setApiKey(apiKey);
		user.setApiSecret(apiSecret);
		this.accountUserBiz.adminUserSetting(user);
		return "redirect:toEnt.do";
	}
}
