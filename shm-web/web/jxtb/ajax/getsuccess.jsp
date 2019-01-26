 <%
	String uname = request.getParameter("uname");
	if(uname.equals("aaa")){
		out.print("true");
	}else{
		out.print("用户名可以使用！");
	}

%>

