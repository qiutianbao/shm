<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>大数据量导出Demo</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/jquery-easyui-1.2.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/jquery-easyui-1.2.6/themes/icon.css">
    <script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
    <script>
        $(function(){
            $('#text').datagrid({
                toolbar:[{
                    text:'导出',
                    iconCls:'icon-save',
                    handler:function(){
                        var url = "${ctx}/export.do?method=exportZip";
                        window.location.href = url;
                    }
                }]
            });
        });
    </script>
</head>
<body>
<h2>大数据量Excel导出ZIP示例</h2>
<table id="text" style="width:700px;height:350px"
       title="示例数据" iconCls="icon-edit" singleSelect="true"
       idField="code" url="${ctx}/export.do?method=loadData">
    <thead>
    <tr>
        <th field="code" width="80">编号</th>
        <th field="name" width="100" >姓名</th>
        <th field="sex" width="80" align="right" >性别</th>
        <th field="blood" width="80" align="right" >血型</th>
        <th field="addr" width="250" >地址</th>
    </tr>
    </thead>
</table><br/>
<font>设定每个文件、每个sheet最大记录数，多xls文件打包成zip导出</font><br/><br/>
<font>边写数据边下载</font>
</body>
</html>