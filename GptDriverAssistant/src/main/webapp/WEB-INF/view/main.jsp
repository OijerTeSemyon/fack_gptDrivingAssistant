<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(basePath);

	if (request.getSession().getAttribute("user")==null){
		  response.sendRedirect("toLogin.do");
	}

%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<title>系统主页</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/prefixfree.min.js"></script>
<style type="text/css">
.top {
	padding-top: 20px;
	padding-left: 20px;
}.line {
	padding-top: 10px;
	padding-left: 100px;
}.opt {
	padding-top: 5px;
	padding-left: 150px;
	font-size: 14px;
}#btnAdd {
	margin-left: 230px;}

.top-menu h1 {
  font-size: 24px;
  margin: 0;
}

.chat-header {
  background-color: #f5f5f5;
}
}.chatbox {
  display: flex;
  align-items: center;
  padding: 10px;
}.chatbox input[type="text"] {
  flex-grow: 1;
  padding: 10px;
  border-radius: 5px;
  border: none;
  margin-right: 10px;
}.chatbox button {
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;


</style>

 </head>
  <body>
  <div class="top-menu">
    <h1>设置</h1>

    <ul class="nav">
        <li><a href="toUserSetting.do">用户设置</a></li>
        <li><a href="toSpeedWarn.do">车速警报设置</a></li>
        <li><a href="toVoice.do">语音识别设置</a></li>
        <li><a href="toEnt.do">管理员设置</a></li>
        <li class="slide1"></li>
        <li class="slide2"></li>
    </ul>
    <script src='js/jquery.min.js'></script>
    <script src="js/script.js"></script>

  <div class="msg">${msg}</div>

  <div class="chat-window">
  <div class="chat-header">
    <h2>GPT行车助手为您服务</h2>
  <div id="chatbox"></div>
  <input type="text" id="inputbox" placeholder="Type your message...">
  <button onclick="sendMessage()">Send</button>
  </div>
</div>

<script>
    function sendMessage() {
      var message = $('#inputbox').val();
      if (message.trim() === '') return;

      $('#chatbox').append('您：' + message + '<br>');
      var reply = "chatgpt api调用错误！";
      $('#chatbox').append('ChatGPT: ' + reply + '<br>');
      $('#chatbox').scrollTop($('#chatbox')[0].scrollHeight);
      $('#inputbox').val('');

      $.post('/send_message', {message: message}, function(data) {
        //$('#chatbox').append('ChatGPT: ' + reply + '<br>');
        //$('#chatbox').scrollTop($('#chatbox')[0].scrollHeight);
      });
    }
    $('#inputbox').on('keydown', function(e){
      if(e.key === "Enter"){
        sendMessage();
      }
    });
  </script>

  </body>
 </html>