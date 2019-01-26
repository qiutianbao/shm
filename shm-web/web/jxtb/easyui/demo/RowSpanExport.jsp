<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>单元格合并Excel导出示例</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/jquery-easyui-1.2.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/jquery-easyui-1.2.6/themes/icon.css">
    <script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/easyui/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/easyui/js/easyuiUtils.js"></script><!-- easyui工具类 -->
    <script>
        $(function(){
            $('#test').datagrid({
                title:'示例数据',
                iconCls:'icon-save',
                width:700,
                height:350,
                nowrap: false,
                striped: true,
                collapsible:true,
                url:'${ctx}/export.do?method=loadRowSpanData',
                columns:[[
                    {field:'province',title:'省份',width:100},
                    {field:'city',title:'地市',width:80},
                    {field:'area',title:'区县',width:100},
                    {field:'dog',title:'流浪狗数量',width:100},
                    {field:'cat',title:'流浪猫数量',width:100},
                    {field:'people',title:'流浪汉数量',width:100}
                ]],
                toolbar:[{
                    id:'btnsave',
                    text:'导出',
                    iconCls:'icon-save',
                    handler:function(){
                        var url = "${ctx}/export.do?method=rowSpanExport";
                        window.location.href = url;
                    }
                }],
                onLoadSuccess:function(){
                    //所有列进行合并操作
                    //$(this).datagrid("autoMergeCells");
                    //指定列进行合并操作
                    $(this).datagrid("autoMergeCells",['province','city','area']);
                }
            });
        });
    </script>
</head>
<body>
<h2>单元格合并Excel导出示例</h2>
<table id="test"></table>
</body>
</html>