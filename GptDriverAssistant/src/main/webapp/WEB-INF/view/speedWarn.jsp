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
  <title>车速警告设置</title>

<script>
function getSpeedRealTime()
{
    var speedRealTime = Math.floor(Math.random() * 21) + 60;
    var s1 = speedRealTime.toString();
    document.getElementById("speedRealTimeLabel").innerHTML = s1;
}
    setInterval("getSpeedRealTime();",1000);
</script>

    <body onload = getSpeedRealTime()>
        <h1>车速警告设置</h1>
            <div id="main">
                <form action="speedWarn.do" method="post">
                <Label>实时车速</Label>
                <Label id = "speedRealTimeLabel"></Label><br><br>
                <Label>超速提醒设置</Label><br><br>
                <input type="checkbox" id="ifOverSpeedWarn" name="ifOverSpeedWarn" >超速提醒<br><br>
                <input type="submit" value="完成">
                </form>
            </div>
    </body>
</html>
