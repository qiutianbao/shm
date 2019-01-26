<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<script type="text/javascript" src="<%=path%>/js/ajax/jquery-1.8.3.js"></script>
<script type="text/javascript">
    /*
     使用Ajax方式无刷新实现注册邮箱验证
     要求用户输入注册邮箱、用户名、密码，如果注册邮箱为shy888@126.com，就提示该邮箱已注册
     否则提示可以使用。
     */

    $(document).ready(function() {
        //1、定义JSON格式的user对象，并在id为objectDiv的div中输出
        var user = {"id":1,"name":"张三","pwd":"000" };
        $("#objectDiv").append("ID："+user.id+"<br>")
                .append("用户名："+user.name+"<br>")
                .append("密码："+user.pwd+"<br>");
        //2、定义JSON格式的字符串数组，并在id为arrayDiv的div中输出
        var ary = ["中","美","俄"];
        for(var i=0;i<ary.length;i++) {
            $("#arrayDiv").append(ary[i]+"  ");
        }
        //3、定义JSON格式的user对象数组，并在id为objectArrayDiv的div中使用<table>输出
        var userArray = [
            {"id":2,"name":"admin","pwd":"123"},
            {"id":3,"name":"詹姆斯","pwd":"11111"},
            {"id":4,"name":"梅西","pwd":"6666"}
        ];
        $("#objectArrayDiv").append("<table>")
                .append("<tr>")
                .append("<td>ID</td>")
                .append("<td>用户名</td>")
                .append("<td>密码</td>")
                .append("</tr>");
        for(var i=0;i<userArray.length;i++) {
            $("#objectArrayDiv").append("<tr>")
                    .append("<td>"+userArray[i].id+"&nbsp;</td>")
                    .append("<td>"+userArray[i].name+"&nbsp;</td>")
                    .append("<td>"+userArray[i].pwd+"</td>")
                    .append("</tr>");
        }
        $("#objectArrayDiv").append("</table>");

    });
</script>
<body>
一、JSON格式的user对象:<div id="objectDiv"></div><br>
二、JSON格式的字符串数组:<div id="arrayDiv"></div><br>
三、JSON格式的user对象数组:<div id="objectArrayDiv"></div>
</body>
</html>