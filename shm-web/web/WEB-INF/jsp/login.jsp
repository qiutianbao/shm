<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-1-19
  Time: 下午12:17
  登录
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
</head>

<body class="login_big_box">
<div  class="login_box">
    <div class="login">
        <h1 class="login_logo"></h1>
        <div class="yh_box"><input type="text"  placeholder="请输入用户名"></div>
        <div class="mm_box"><input type="text"  placeholder="请输入密码"></div>
        <div class="login11">
            <i><input checked="checked" id="checkbox-21" class="regular-checkbox01" type="checkbox"><label for="checkbox-21"></label></i><a href="#" class="login_a1">记住密码</a>
            <a class="login_a2" href="#">忘记密码</a>
            <div class="clearfix"></div>
        </div>
        <div class="login_d"><a href="#">立即登陆</a></div>
        <div class="login12">
            <span>还没有账号？</span><a href="#">注册账号</a>
        </div>
    </div>
</div>
</body>
</html>
