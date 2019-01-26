<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
	String uname = request.getParameter("uname");
	if(uname.equals("aaa")){
		out.print("用户名不能使用!"+uname);
	}else{
		out.print("用户名可以使用！");
	}

%>

