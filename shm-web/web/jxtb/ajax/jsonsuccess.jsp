<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%

    String uname = request.getParameter("uname");
     System.out.println(uname);
	if("aaa".equals(uname)){
		out.print("{\"flag\":true,\"msg\":\"<font color='red'>用户名已被使用！</font>\"}");
	}else{
		out.print("{\"flag\":false,\"msg\":\"<font color='green'>用户名可以使用！</font>\"}");
	}
%>

