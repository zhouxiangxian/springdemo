<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String addUrl=request.getContextPath()+"/rest/param/queryForm";
%>
<form action="<%=addUrl %>" method="post" >
	雇员姓名:<input type="text" name="msg" id="msg" value="周湘贤"><br/>
	<input type="submit" value="提交">
</form>
</body>
</html>