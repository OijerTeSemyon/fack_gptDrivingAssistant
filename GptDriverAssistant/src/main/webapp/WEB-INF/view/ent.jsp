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
<title>管理员界面</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.7.1.min.js"></script>
<style type="text/css">
.top {
	padding-top: 20px;
	padding-left: 20px;
}

.line {
	padding-top: 10px;
	padding-left: 100px;
}

.opt {
	padding-top: 5px;
	padding-left: 150px;
	font-size: 14px;
}

#btnAdd {
	margin-left: 230px;
}
</style>
<script>
	//获取选中的记录主键ID，返回-1代表没有选中
	function getSelectedId() {
		var radios = document.getElementsByName("admin_user_userId"); //$("[name='grup_radio']");
		var id = "-1";
		for (var i = 0; i < radios.length; i++) {
			var radio = radios[i];
			if (radio.checked) {
				id = radio.value;
				break;
			}
		}
		return id;
	}

	$(function() {
        $("#btnAdd").click(function() {
			var url = "toRegister.do";
            location.href = url;
		});

		//删除按钮的点击事件
		$("#btnDel").click(function() {
			var id = getSelectedId();
			if (id != -1) {
				if (confirm("你确定要删除这个用户吗?")) {
					var url = "userDel.do?id=" + id;
					location.href = url;
				}
			} else {
				alert("请选择要删除的用户！");
			}

		});

		//修改按钮的点击事件
		$("#btnUpdate").click(function() {
			var id = getSelectedId();
			if (id != -1) {
				var url = "userUpdate.do?id=" + id
				location.href = url;
			} else {
				alert("请选择要修改的记录！");
			}

		});

	});
</script>

</head>
<body>
	<h1>管理员设置</h1>
	<div class="top">
	<div class="line">
		<hr style="width: 80%" />
	</div>
	<div class="opt">
        <button id="btnAdd">添&nbsp;加</button>
		&nbsp;&nbsp;
		<button id="btnUpdate">修&nbsp;改</button>
		&nbsp;&nbsp;
		<button id="btnDel">删&nbsp;除</button>
	</div>
	<div class="main">
		<table id="t1">
			<tr>
			    <th></th>
				<th>id</th>
				<th>用户名</th>
				<th>apiKey</th>
				<th>apiSecret</th>
			</tr>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td><input type="radio" value="${user.userId}" name="admin_user_userId" /></td>
					<td><c:out value="${user.userId}"  /></td>
					<td><c:out value="${user.userName}"  /></td>
					<td><c:out value="${user.apiKey}" /></td>
					<td><c:out value="${user.apiSecret}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>