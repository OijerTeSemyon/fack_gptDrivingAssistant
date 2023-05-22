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
  <title>语音设置</title>
</head>
<body>
<div id="main">
  <h1>语音设置</h1>
    <div id="main">
                <form action="voice.do" method="post">
                <input type="checkbox" id="ifVoiceOn" name="ifVoiceOn" >语音识别启动<br><br>
                <input type="submit" value="完成">
         </form>
    </div>
 </div>
</body>
</html>