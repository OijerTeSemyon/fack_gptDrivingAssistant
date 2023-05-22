<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);


%>

<!DOCTYPE html>
<html>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/main.css" type="text/css" rel="stylesheet"/>
<head>
  <title>用户设置</title>
</head>
<body>
<div id="main">
  <h1>用户设置</h1>
  <img src="<%=basePath%>uploads/${user.imageLocation}" alt="Image" height="200" width="200">
    <form action="getUpLoadImage.do" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/>
    <input type="submit" value="上传头像"/>
</form>

  <form action="userSetting.do" method="post">
    <label for="userName">用户名</label>
    <input type="text" id="userName" name="userName"  readonly="readonly" value = "${user.userName}" ><br><br>
    <label for="password">密码:</label>
    <input type="password" id="passWord" name="passWord" value = "${user.passWord}" ><br><br>
    <label for="apiKey">API Key:</label>
    <input type="text" id="apiKey" name="apiKey" value = "${user.apiKey}" ><br><br>
    <label for="apiSecret">API Secret:</label>
    <input type="text" id="apiSecret" name="apiSecret" value = "${user.apiSecret}" ><br><br>
    <input type="submit" value="完成">
  </form>
 </div>
</body>
</html>