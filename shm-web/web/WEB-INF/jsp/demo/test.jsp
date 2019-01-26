<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17-1-18
  Time: 下午3:47
  内容
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script src="${ctx}/js/echarts/build/dist/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/mould.js"></script>
<script type="text/javascript" src="${ctx}/js/shouye.js"></script>
<script type="text/javascript" src="${ctx}/js/other.js"></script>
<script type="text/javascript" src="${ctx}/js/price.js"></script>
<script type="text/javascript" src="${ctx}/js/gongxu.js"></script>

<div class="content_box">
<div class="data_box">
    <h1>分析和解读</h1>
    <div class="fx_box">
        <div class="fx_left">
            <li>
                <a href="Javascript:void('0')" onclick="window.location.href ='分析和解读更多.html';">安迅思追踪：德国巴斯夫爆炸事件或提振欧美苯乙烯行情 影响中国进口量</a>
                <span>2016/10/26</span>
            </li>
            <li class="fx_l" >
                <a href="Javascript:void('0')">化工市场瞭望（10月17日-10月21日）：纯MDI大幅度上涨</a>
                <span>2016/10/22</span>
            </li>
            <li>
                <a href="Javascript:void('0')">苯乙烯年度数据解读</a>
                <span>2016/10/21</span>
            </li>
        </div>
        <div class="fx_rigth">
            <li>
                <a href="Javascript:void('0')">苯乙烯类行业迎来黄金时代</a>
                <span>2016/10/10</span>
            </li>
            <li class="fx_l">
                <a href="Javascript:void('0')">苯乙烯周度数据解读</a>
                <span>2016/10/02</span>
            </li>
            <li class="fx_l01">
                <span class="fx_gd"><a href="Javascript:void('0')">查看更多>></a></span>
            </li>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="data_box01">
    <div class="data_top">
        <span class="details"><a onclick="showDetail_price()">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>价格</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="china_price">
            <a href="javascript:void('0')" onclick="domestic_price();">国内价格</a>
        </li>
        <li class="china" id="unchina_price">
            <a href="javascript:void('0')" onclick="abroad_price();">全球价格</a>
        </li>
        <div class="day_box" id="jiage_weidu">
            <span id="day_price"><a onclick="day();">日</a></span>
            <span id="week_price"><a onclick="week();">周</a></span>
            <span id="moon_price"><a onclick="moon();">月</a></span>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="tb"  id="domestic_price">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="tb_title">
                <th style="width:20%;">日期</th>
                <th style="width:21%;">类型</th>
                <th style="width:22%;">价格</th>
                <th style="width:22%;">涨跌</th>
                <th style="width:15%;">单位</th>
            </tr>
            <tr class="tb_content" onclick="guonei(1,1);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>华东</th>
                <th><span >8450</span>—<span >8400</span></th>
                <th><span style="color:#00c533;">-50</span> / <span style="color:#00c533;">-50</span></th>
                <th>元/吨</th>
            </tr>
            <tr onclick="guonei(2,1);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>华南</th>
                <th><span >8500</span>—<span >8620</span></th>
                <th><span style="color:#ff0000;">+120</span> / <span style="color:#ff0000;">+200</span></th>
                <th>元/吨</th>
            </tr>
            <tr class="tb_content" onclick="guonei(3,1);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>远期现货</th>
                <th><span >8000</span>—<span >8160</span></th>
                <th><span style="color:#00c533;">-160</span> / <span style="color:#ff0000;">+70</span></th>
                <th>元/吨</th>
            </tr>
            <tr onclick="guonei(4,1);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>CFR华东</th>
                <th>1030—1040</th>
                <th>0/0</th>
                <th>元/吨</th>
            </tr>
        </table>
    </div>

    <div class="tb" id="abroad_price">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr class="tb_title">
                <th style="width:20%;">日期</th>
                <th style="width:21%;">类型</th>
                <th style="width:22%;">价格</th>
                <th style="width:22%;">涨跌</th>
                <th style="width:15%;">单位</th>
            </tr>
            <tr class="tb_content" onclick="guowai(1,2);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>FOB美国海湾</th>
                <th><span >930</span>—<span >970</span></th>
                <th><span style="color:#ff0000;">+40</span> / <span style="color:#ff0000;">+5</span></th>
                <th>美元/吨</th>
            </tr>
            <tr onclick="guowai(2,2);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>FOB鹿特丹</th>
                <th><span >960</span>—<span >1030</span></th>
                <th><span style="color:#ff0000;">+70</span> / <span style="color:#ff0000;">+50</span></th>
                <th>美元/吨</th>
            </tr>
            <tr class="tb_content" onclick="guowai(3,2);" style="cursor:pointer">
                <th>2016/10/21</th>
                <th>FOB韩国主港</th>
                <th><span >869</span>—<span >891</span></th>
                <th><span style="color:#ff0000;">+22</span> / <span style="color:#ff0000;">+20</span></th>
                <th>美元/吨</th>
            </tr>
        </table>
    </div>
    <div class="tb echartAuto" id="tb_price"></div>
</div>
<div class="data_box02">
    <div class="data_top">
        <span class="details"><a href="首页_供需_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>供需</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="kaigonglv" picdom="tb_jg">
            <a href="javascript:void('0')" onclick="c_jg()">产能产量开工率</a>
        </li>
        <li class="china" id="biaoguan">
            <a href="javascript:void('0')" onclick="c_biaoguan()">表观需求</a>
        </li>
        <li class="china" id="jinchukou">
            <a href="javascript:void('0')" onclick="c_jinchukou()">进出口</a>
        </li>
        <li class="china" id="xiayouxuqiu">
            <a href="javascript:void('0')" onclick="c_xiayouxuqiu()">下游需求</a>
        </li>
        <li class="china" id="kucun">
            <a href="javascript:void('0')" onclick="c_xl()" >库存</a>
        </li>
        <li class="china" id="yuce">
            <a href="javascript:void('0')" onclick="c_yuce()">供需预测</a>
        </li>
        <div class="day_box" mod="gx">
            <span class="week"><a onclick="week_gx();">周</a></span>
            <span class="month"><a onclick="moon_gx();">月</a></span>
            <span class="year"><a onclick="year_gx();">年</a></span>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="tb echartAuto" id="tb_jg"></div>
    <div class="tb echartAuto" id="tb_biaoguan"></div>
    <div class="tb echartAuto" id="tb_jinchukou"></div>
    <div class="tb echartAuto" id="tb_xiayouxuqiu"></div>
    <div class="tb echartAuto" id="tb_xl"></div>
    <div class="tb echartAuto" id="tb_yuce"></div>

    <div class="tb" id="xl_tab">
        <div class="tab_h">

            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="tb_title">
                    <th style="width:15%;">日期</th>
                    <th style="width:12%;">区域</th>
                    <th style="width:13%;">库存</th>
                    <th style="width:12%;">涨跌</th>
                    <th style="width:12%;">单位</th>
                    <th style="width:12%;">价格</th>
                    <th style="width:12%;">涨跌</th>
                    <th style="width:12%;">单位</th>
                </tr>
            </table>
        </div>

        <div class="tab_b">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="tb_content"  onclick="changeXl(1);" style="cursor:pointer">
                    <th style="width:15%;">2016/10</th>
                    <th style="width:12%;">华东</th>
                    <th style="width:13%;">7.675</th>
                    <th style="width:12%;"><span style="color:#00c533;">-1.1214</span></th>
                    <th style="width:12%;">万吨</th>
                    <th style="width:12%;">8531</th>
                    <th style="width:12%;"><span style="color:#ff0000;">+11</span></th>
                    <th style="width:12%;">元/吨</th>
                </tr>
                <tr  onclick="changeXl(2);" style="cursor:pointer">
                    <th>2016/10</th>
                    <th>华南</th>
                    <th>6.676</th>
                    <th><span style="color:#00c533;">-1.432</span></th>
                    <th>万吨</th>
                    <th>8308</th>
                    <th><span style="color:#00c533;">-48</span></th>
                    <th>元/吨</th>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="data_box03" >
<div class="data_top">
    <span class="download" style="margin-right:20px;"><img src="${ctx}/images/download.png"></span>
    <h1>装置/船期</h1>
</div>
<div class="data_nav_box">
    <li class="china" id="china_jg">
        <a href="javascript:void('0')" onclick="changeCq('tcjx')">停车检修</a>
    </li>
    <li class="china">
        <a href="javascript:void('0')" onclick="changeCq('cq')">船期</a>
    </li>
    <li class="china">
        <a href="javascript:void('0')" onclick="changeCq('kjgt')">扩建/关停</a>
    </li>
</div>


<div class="tb" id="tcjx">
    <div class="tab_h">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_title" >
                <th style="width:13%;">工厂</th>
                <th style="width:12%;">类型</th>
                <th style="width:14%;">状态</th>
                <th style="width:12%;">基准开工率</th>
                <th style="width:12%;">产能（万吨/年）</th>
                <th style="width:13%;">影响本月产量（万吨）</th>
                <th style="width:12%;">开始时间</th>
                <th style="width:12%;">结束时间</th>
            </tr>
        </table>
    </div>
    <div class="tab_b">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_content">
                <th style="width:13%;">江苏利士德</th>
                <th style="width:12%;">停车检修</th>
                <th style="width:14%;">计划内停车检修</th>
                <th style="width:12%;">45%</th>
                <th style="width:12%;">20</th>
                <th style="width:13%;"><span style="color:#00c533;">-0.75</span></th>
                <th style="width:12%;">2016/1/1</th>
                <th style="width:12%;">2016/1/31</th>
            </tr>
            <tr >
                <th>镇利化学</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>100%</th>
                <th>62</th>
                <th><span style="color:#00c533;">-0.34</span></th>
                <th>2015/12/14</th>
                <th>2015/12/18</th>
            </tr>
            <tr class="tb_content">
                <th>盘锦乙烯</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>51%</th>
                <th>8</th>
                <th>3.80</th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
            <tr>
                <th>中海壳牌</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>45%</th>
                <th>20</th>
                <th><span style="color:#00c533;">-0.75</span></th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
            <tr class="tb_content">
                <th>湛江东兴</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>100%</th>
                <th>20</th>
                <th><span style="color:#00c533;">-0.99</span></th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
            <tr>
                <th>山东玉皇</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>100%</th>
                <th>20</th>
                <th><span style="color:#00c533;">-1.50</span></th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
            <tr class="tb_content">
                <th>湛江东兴</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>100%</th>
                <th>20</th>
                <th><span style="color:#00c533;">-0.99</span></th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
            <tr>
                <th>山东玉皇</th>
                <th>停车检修</th>
                <th>计划内停车检修</th>
                <th>100%</th>
                <th>20</th>
                <th><span style="color:#00c533;">-1.50</span></th>
                <th>2016/1/1</th>
                <th>2016/1/31</th>
            </tr>
        </table>
    </div>
</div>
<div class="tb" id="cq" style="display:none;">
    <div class="tab_h">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_title" >
                <th style="width:12%;">预期抵达日期</th>
                <th style="width:12%;">预期出发日期</th>
                <th style="width:12%;">产品规格</th>
                <th style="width:12%;">船名</th>
                <th style="width:10%;">数量（吨）</th>
                <th style="width:13%;">出发地</th>
                <th style="width:17%;">到达地</th>
                <th style="width:12%;">备注</th>
            </tr>
        </table>
    </div>
    <div class="tab_b">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_content">
                <th style="width:12%;">2016/9/8</th>
                <th style="width:12%;">2016/8/1</th>
                <th style="width:12%;">苯乙烯</th>
                <th style="width:12%;">红宝石</th>
                <th style="width:10%;">400</th>
                <th style="width:13%;">美国</th>
                <th style="width:17%;">中国-江阴-江阴奥德菲尔嘉盛化工仓储有限公司</th>
                <th style="width:12%;">贸易商</th>
            </tr>
            <tr >
                <th>2016/9/7</th>
                <th>2016/8/1</th>
                <th>苯乙烯</th>
                <th>华运明尼</th>
                <th>16500</th>
                <th>美国</th>
                <th>中国-江阴-江阴华西化工码头有限公司</th>
                <th>贸易商</th>
            </tr>
            <tr class="tb_content">
                <th>2016/9/7</th>
                <th>2016/8/1</th>
                <th>苯乙烯</th>
                <th>海门星系</th>
                <th>3000</th>
                <th>加拿大</th>
                <th>中国-江阴-中国石化江苏江阴石油分公司长山油库</th>
                <th>贸易商</th>
            </tr>
            <tr>
                <th>2016/9/5</th>
                <th>2016/8/1</th>
                <th>苯乙烯</th>
                <th>银色宇宙</th>
                <th>5700</th>
                <th>科威特</th>
                <th>中国-江阴-江阴丽天石化码头有限公司</th>
                <th>贸易商</th>
            </tr>
        </table>
    </div>
</div>

<div class="tb" id="kjgt" style="display:none;">
    <div class="tab_h">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_title" >
                <th style="width:16%;">扩建/关停日期</th>
                <th style="width:16%;">工厂</th>
                <th style="width:16%;">类型</th>
                <th style="width:16%;">状态</th>
                <th style="width:16%;">产能</th>
                <th style="width:16%;">影响产量</th>
            </tr>
        </table>
    </div>
    <div class="tab_b">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
            <tr class="tb_content">
                <th style="width:16%;">2010/7</th>
                <th style="width:16%;">河北任丘</th>
                <th style="width:16%;"></th>
                <th style="width:16%;">永久关停</th>
                <th style="width:16%;">8</th>
                <th style="width:16%;">5.5</th>
            </tr>
            <tr >
                <th>2010/11</th>
                <th>大庆中蓝</th>
                <th></th>
                <th>永久关停</th>
                <th>8</th>
                <th>5.5</th>
            </tr>
            <tr class="tb_content">
                <th>2012/3</th>
                <th>大连石化</th>
                <th></th>
                <th>永久关停</th>
                <th>10</th>
                <th>7.2</th>
            </tr>
            <tr>
                <th>2015/1</th>
                <th>山东晟原</th>
                <th></th>
                <th>新投产</th>
                <th>6</th>
                <th>5.5</th>
            </tr>
        </table>
    </div>
</div>
</div>
<div class="data_box01">
    <div class="data_top">
        <span class="details"><a href="首页_利润_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>利润</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="china_jg">
            <a href="javascript:void('0')" onclick="changeTab()">利润</a>
        </li>
        <li class="china" id="">
            <a href="javascript:void('0')" onclick="changeTab2()">套利</a>

        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="tb echartAuto" id="tb_lirun"></div>
    <div class="tb" id="taoli">
        <div class="tab_h">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr class="tb_title">
                    <th style="width:23%;">日期</th>
                    <th style="width:23%;">类型</th>
                    <th style="width:18%;">差价</th>
                    <th style="width:18%;">变化</th>
                    <th style="width:18%;">单位</th>
                </tr>
            </table>
            <div class="tab_b">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr class="tb_content">
                        <th style="width:23%;">2016/10/21</th>
                        <th style="width:23%;">进口VS国内</th>
                        <th style="width:18%;">4</th>
                        <th style="width:18%;"><span style="color:#ff0000;">+1</span></th>
                        <th style="width:18%;">美元/吨</th>
                    </tr>
                    <tr >
                        <th>2016/10/21</th>
                        <th>进口VS美国</th>
                        <th>-24</th>
                        <th><span style="color:#00c533;">-14</span></th>
                        <th>美元/吨</th>
                    </tr>
                    <tr class="tb_content">
                        <th>2016/10/21</th>
                        <th>进口VS韩国</th>
                        <th>0</th>
                        <th>0</th>
                        <th>美元/吨</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="data_box02">
    <div class="data_top">
        <span class="details"><a href="首页_上游_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>上游</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="china_jg" style="background-image:url(${ctx}/images/xl.png); background-size:17px 14px; background-position:center right; background-repeat:no-repeat; padding-right:20px;">
            <a href="javascript:void('0')" onclick="c_shangyou(1)">纯苯</a>
            <dl style="width:130%;">
                <dd><a class="zx" onclick="c_shangyou(1)">价格对比</a></dd>
                <dd><a class="zx" onclick="c_shangyou(2)">进出口</a></dd>
            </dl>
        </li>
        <li class="china" id="xl">
            <a href="javascript:void('0')">乙烯</a>
            <dl style="width:130%;">
                <dd><a class="zx" >价格对比</a></dd>
                <dd><a class="zx" >进出口</a></dd>
            </dl>
        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix">
            </div>
        </div>

    </div>
    <div class="tb echartAuto" id="tb_jgdb"></div>
    <div class="tb echartAuto" id="tb_jck" ></div>
</div>
<div class="data_box01">
    <div class="data_top">
        <span class="details"><a href="首页_下游_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>下游</h1>
    </div>
    <div class="data_nav_box">
        <li class="china">
            <a href="javascript:void('0')">价格</a>
        </li>
        <li class="china">
            <a href="javascript:void('0')">开工率</a>
        </li>
        <li class="china" id="">
            <a href="javascript:void('0')">利润</a>
        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="tb echartAuto" id="tb_xiayouLirun"></div>
</div>
<div class="data_box02">
    <div class="data_top">
        <span class="details"><a href="首页_宏观_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>宏观数据</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="china_jg">
            <a href="javascript:void('0')">汇率</a>
        </li>
        <li class="china">
            <a href="javascript:void('0')">油价</a>
        </li>
        <li class="china">
            <a href="javascript:void('0')">GDP</a>
        </li>
        <li class="china">
            <a href="javascript:void('0')">PMI</a>
        </li>
        <li class="china">
            <a href="javascript:void('0')">PPI</a>
        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="tb echartAuto" id="tb_huilv"></div>
</div>
<div class="data_box01">
    <div class="data_top">
        <span class="details"><a href="首页_行业_详情.html">查看详情</a></span>
        <span class="download"><img src="${ctx}/images/download.png"></span>
        <h1>行业数据</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" id="china_jg" style="background-image:url(${ctx}/images/xl.png); background-size:17px 14px; background-position:center right; background-repeat:no-repeat; padding-right:20px;">
            <a href="#">房地产业</a>
            <dl style="width:140%;">
                <dd class="xy">
                    <a class="zx" href="Javascript:void('0')">商品房</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="Javascript:void('0')">土地开发</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="Javascript:void('0')">投资及景气指数</a>
                </dd>
            </dl>
        </li>
        <li class="china" id="xl">
            <a href="#">制造行业</a>
            <dl style="width:160%;">
                <dd class="xy">
                    <a class="zx" href="#">纺织品生产</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">纺织品主要指标</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">工业主要指标</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">家电主要产品产量</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">汽车主要指标</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">机械产品生产</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">机械产品进出口</a>
                </dd>
            </dl>
        </li>
        <li class="china" id="xl">
            <a href="#">金融期货</a>
            <dl >
                <dd class="xy">
                    <a class="zx" href="#">天然橡胶</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">沥青</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">燃料油</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">PTA</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">甲醇</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">动力煤</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">PP</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">PVC</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">PE</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">焦炭</a>
                </dd>
            </dl>
        </li>
        <li class="china" id="xl">
            <a href="#">运输和储存业</a>
            <dl >
                <dd class="xy">
                    <a class="zx" href="#">主要指标</a>
                </dd>
            </dl>
        </li>
        <li class="china" id="xl">
            <a href="#">能源和化工</a>
            <dl style="width:120%;">
                <dd class="xy">
                    <a class="zx" href="#">石化产品进出口</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">原油平衡表</a>
                </dd>
                <dd class="xy">
                    <a class="zx" href="#">能源主要指标</a>
                </dd>

            </dl>
        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="tb echartAuto" id="tb_fdc"></div>
</div>
<div class="data_box02">
    <div class="data_top">
        <span class="download" style="margin-right: 20px"><img src="${ctx}/images/download.png"></span>
        <h1>安迅思指数</h1>
    </div>
    <div class="data_nav_box">
        <li class="china" >
            <a >化工指数</a>
        </li>
        <li class="china" id="">
            <a >能源指数</a>
        </li>
        <div class="day_box">
            <span class="day_forecast"><a href="Javascript:void('0')">周</a></span>
            <span><a href="Javascript:void('0')">月</a></span>
            <span><a href="Javascript:void('0')">年</a></span>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="tb echartAuto" id="tb_nyzs"></div>
</div>
</div>