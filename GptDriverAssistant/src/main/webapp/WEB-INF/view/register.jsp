<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>GPT行车助手Web端</title>

<link type="text/css" href="css/style.css" rel="stylesheet" />

</head>
<body>

<div class="container">
  <form action="register.do" method="post">
    <p>GPT行车助手账户注册</p>
    <input type="text" required="required" placeholder="用户名" name="userName"></input><br>
    <input type="password" required="required" placeholder="密码" name="passWord"></input><br>
    <input type="password" required="required" placeholder="重复密码" name="passWord2"></input><br>
    <input type="submit" value = "注册">
    <div class="msg">${msg}</div>
  </form>

  <div class="drops">
    <div class="drop drop-1"></div>
    <div class="drop drop-2"></div>
    <div class="drop drop-3"></div>
    <div class="drop drop-4"></div>
    <div class="drop drop-5"></div>
  </div>
</div>

</body>
</html>


