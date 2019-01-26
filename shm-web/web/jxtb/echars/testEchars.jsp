<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-4-5
  Time: 上午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/echarts/build/dist/echarts-all.js"></script>
<html>
<head>
    <title></title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    myChart.clear();
    myChart.showLoading({
        text: '正在努力的读取数据中...',    //loading话术
        effect: 'whirling'
    });

    myChart.showLoading({
        effect:'bubble',
        text : '暂无数据',
        textStyle :{fontSize : 20 ,color : '#404040'},
        effectOption:{backgroundColor: '#fefefe'}
    });

    // 指定图表的配置项和数据
    var option = {
        //标题
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        //图例
        legend: {
            data:['销量','产能','开工率']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
   //myChart.setOption(option);

    //myChart.hideLoading();
</script>
</body>
</html>