<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=path%>/js/ajax/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function check() {
            var name = $.trim($('#name').attr('value'));
            var pwd = $.trim($('#pwd').attr('value'));
            if ("" == name || "" == pwd) {
                alert('用户名或者密码不能为空');
            } else {
                $.ajax({
                    type : 'post',
                    //url : 'loginSucc.jsp?name=' + name + '&pwd=' + pwd,
                    url : '/ajaxTest/login.action?name=' + name + '&pwd=' + pwd,
                    success : function(msg) {
                        if('success'==msg){
                            location.href='<%=basePath%>admin/index.jsp' ;
                        }else{
                            $('#msg').html(msg);
                        }
                    }
                });
                 
            }
        }
    </script>
  </head>
  
  <body>
    <input type="text" name="name" id="name" /><br />
     密码：<input type="password" name="pwd" id="pwd" /><br />
    <input id='sub' type="button" value="确定" onclick="check()"/><br />
    <label id="msg"></label>
  </body>
</html>
