<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'jsonLogin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/ajax/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/ajax/jsonLogin.js"></script>

</head>

<body>
	<div id="msg"></div>
   
	username：

	<input name="admin.username" id="username" type="text" />
	<br /> password：

	<input name="admin.password" id="password" type="password" />

	<br />

	<input type="submit" id="submit" value="login">

</body>
</html>
