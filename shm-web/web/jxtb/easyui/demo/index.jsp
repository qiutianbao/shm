<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Easyui + Spring Mvc导出Excel：支持按模板样式导出，支持合并表头、合并单元格、多sheet导出，支持小计功能；POI方法封装，操作简单</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<h1>Easyui + Spring Mvc导出Excel</h1>
<p> <a href="jxtb/easyui/demo/exportExcel.jsp" target="_blank">普通导出</a> </p>
<p> <a href="jxtb/easyui/demo/spanExport.jsp" target="_blank">多重列表头导出</a> </p>
<p> <a href="jxtb/easyui/demo/exportSheets.jsp" target="_blank">多sheet导出</a> </p>
<p> <a href="jxtb/easyui/demo/RowSpanExport.jsp" target="_blank">合并单元格导出</a> </p>
<p> <a href="jxtb/easyui/demo/exportTotal.jsp" target="_blank">带小计合并单元格导出</a> </p>
<p> <a href="jxtb/easyui/demo/exportZip.jsp" target="_blank">大数据量导出（多文件、多sheet、zip包、边导出边下载）</a> </p>
</body>
</html>
