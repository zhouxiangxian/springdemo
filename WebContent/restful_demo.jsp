<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resutful架构</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/restful_demo.js"></script>
<body>
	<div id="btnDiv">
		<button id="addMember">增加用户</button>
		<button id="editMember">编辑用户</button>
		<button id="removeMember">删除用户</button>
		<button id="getMember">查询用户</button>
		<button id="listMember">列表用户</button>
	</div>
	<div id="showDiv"></div>
</body>
</html>