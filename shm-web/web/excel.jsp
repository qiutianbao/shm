<%@ page import="com.jxtb.test.dao.StudentDao" %>
<%@ page import="com.jxtb.test.controller.ExcelUtil" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    try {
        List<HashMap<String, Object>> students = StudentDao.findStudents();
        pageContext.setAttribute("students", students);
        String filePath=request.getRealPath("/"+"student.xls");
        //ExcelUtil.exportData(students,filePath);
        out.print("<a href='/student.xls'>下载</a>");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<table border="1" cellpading="0" cellspacing="0" style="width: 100%">
    <thead>
    <th>编号</th>
    <th>姓名</th>
    <th>密码</th>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.pwd}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<form role="form" action="/leadingInUpload.shtml" method="POST" enctype="multipart/form-data">
    <div class="form-group">
        <label for="file">上传文件</label>
        <input type="file" id="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>

</body>
</html>