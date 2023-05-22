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
  <title>用户编辑</title>
</head>
<body>
<div id="main">
  <h1>用户编辑</h1>
  <form action="adminUserSetting.do" method="post">
    <label for="apiKey">uid:</label>
    <input type="text" id="userId" name="userId" value = "${user.userId}" readonly="readonly"><br><br>
    <label for="userName">用户名</label>
    <input type="text" id="userName" name="userName"  readonly="readonly" value = "${user.userName}" ><br><br>
    <label for="apiKey">API Key:</label>
    <input type="text" id="apiKey" name="apiKey" value = "${user.apiKey}" ><br><br>
    <label for="apiSecret">API Secret:</label>
    <input type="text" id="apiSecret" name="apiSecret" value = "${user.apiSecret}" ><br><br>
    <input type="submit" value="完成">
  </form>
 </div>
</body>
</html>