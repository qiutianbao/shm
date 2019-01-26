<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-3-28
  Time: 上午11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1>读取Session中保存的用户名</h1>
<div>欢迎您，${sessionScope.CURRENT_USER}！</div>
<div>
    <s:fielderror/>---->显示服务器返回的错误信息
</div>
<s:form action="/login.action">
    <div>
        用户名：<s:textfield name="username" />
    </div>
    <div>
        密码：<s:password name="password" />
    </div>
    <div><s:submit value="登录" /></div>
</s:form>
</body>
</html>