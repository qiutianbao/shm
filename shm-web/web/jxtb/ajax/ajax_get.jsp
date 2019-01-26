<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
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
	 
	function validate(){
	 	var uname = $("#uname").val();
		if(uname==null || uname==""){
			alert("用户名不能为空！");
		}else{
		
			$.ajax({
				//url:'ajax_getsuccess.jsp',
				url:'/ajaxTest/ajax_get.action',
				type:'get',
				data:'uname='+uname,
				success:function(result){
					if($.trim(result) == "true"){
						$("#unameDiv").html("用户名已被使用！");
				    }else{
						$("#unameDiv").html("用户名可以使用！");
				    } 
				},
				error:function(){
					alert("ajax执行失败！");
				}
			});
		}
	}
</script>

  </head>
  
  <body>
     <form action="" id="form1" >
		<table>
			<tr>
				<td>用 户 名：</td>
				<td>
					<input  type="text" name="uname" id="uname" onblur="validate();" />&nbsp;<font color="#c00fff">*</font>
				</td>
				<td>
					<div id="unameDiv" style="display: inline"></div>
				</td>
				<td >
				 <!--   <input type="submit" value="登陆" onclick="validate()"> -->
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
