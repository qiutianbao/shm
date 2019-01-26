<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.jxtb.test.dao.ShoppingDao" %>
<%@ page import="com.jxtb.test.entity.Product" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>贵美商城首页</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath%>/css/guimei/busywork_guimei.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
    //获取所有商品信息集合
    int i=0;
    ShoppingDao shopping=new ShoppingDao();
    List<Product> products=shopping.getAllProducts();
%>
<script src="<%=path%>/js/ajax/busywork_guimei.js" type="text/javascript"></script>
<!--网页导航部分开始-->
<div id="header">
    <div class="header_top">
        <ul>
            <li class="pic pic1"></li>
            <li class="top_menu_text ">
                <a href="#">购物车</a>
            </li>
            <li class="pic pic2"></li>
            <li class="top_menu_text">
                <a href="#">帮助中心</a>
            </li>
            <li class="pic pic3"></li>
            <li class="top_menu_text">
                <a href="javascript:addCookie()">加入收藏</a>
            </li>
            <li class="pic pic4"></li>
            <li class="top_menu_text">
                <a href="javascript:setHomePages()">设为首页</a>
            </li>
            <li class="pic btn">
                <a href="#">登录</a>
            </li>
            <li class="pic btn">
                <a href="#">注册</a>
            </li>
        </ul>
    </div>
    <div class="header_middle" id="header_middle">
        <script type="text/javascript">time()</script>
    </div>
    <div class="nav">
        <ul>
            <li>
                <a href="#">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a>
            </li>
            <li>
                <a href="#">家用电器</a>
            </li>
            <li>
                <a href="#">手机数码</a>
            </li>
            <li>
                <a href="#">日用百货</a>
            </li>
            <li>
                <a href="#">&nbsp;书&nbsp;&nbsp;&nbsp;籍&nbsp;</a>
            </li>
            <li>
                <a href="#">帮助中心</a>
            </li>
            <li>
                <a href="#">免费开店</a>
            </li>
            <li>
                <a href="#">销售管理</a>
            </li>
        </ul>
    </div>
</div>
<!--网页中间部分开始-->
<div id="main">
<!--左则菜单开始-->
<div class="cat">
    <ul id="cat_menu">
        <!--
本菜单使用纯HTML实现的代码如下：
<li class="cat_class">家用电器</li>
<li class="cat_li">大家电</li>
......
<li class="cat_li">摄像机</li>
<li class="cat_class">书籍</li>
<li class="cat_li">文学</li>
......
<li class="cat_li">法律</li>
<li class="cat_class">手机数码</li>
<li class="cat_li">电脑整机</li>
......
<li class="cat_li">网线</li>
<li class="cat_class">日用百货</li>
<li class="cat_li">儿童床品</li>
......
<li class="cat_li">减肥</li>

本例使用JavaScript方法实现
-->
        <script type="text/javascript">menu()</script>
    </ul>
</div>
<!--中间广告和疯狂购物开始-->
<div class="content">
    <!--带按钮的横幅广告开始-->
    <div class="adRotator">
        <img src="<%=basePath%>/images/guimei/guimei_ad-01.jpg" alt="scroll" id="adverImg" />
        <div class="number_bg">
            <a href="javascript:adver(1)" class="advers">1</a>
            <a href="javascript:adver(2)" class="advers">2</a>
            <a href="javascript:adver(3)" class="advers">3</a>
            <a href="javascript:adver(4)" class="advers">4</a>
        </div>
    </div>
    <!--疯狂购物开始-->
    <div style="width: 524px;">
        <table border="0" cellpadding="1" cellspacing="1"
               style="text-align: center; margin: 0 auto; border-color: gray; width: 524px;">
            <thead>
            <tr
                    style="font-weight: bold; background: #FFBA75; text-align: center">
                <td class="top_menu_text ">
                    商品ID
                </td>
                <td class="top_menu_text ">
                    商品名称
                </td>
                <td class="top_menu_text ">
                    单价（元）
                </td>
                <td class="top_menu_text ">
                    生产厂家
                </td>
                <td class="top_menu_text ">
                    保质期
                </td>
                <td class="top_menu_text ">
                    销售量
                </td>
            </tr>
            </thead>
            <tbody>
            <%
                //隔行变色
                for(Product pro : products) {
                    i++;
                    if(i%2==0){
            %>
            <tr style="background: #FFBA75;">
                    <%}else{ %>

            <tr>
                <%} %>
                <td><%=pro.getId() %></td>
                <td><%=pro.getName() %></td>
                <td><%=pro.getPrice() %></td>
                <td><%=pro.getFactory() %></td>
                <td><%=pro.getBaoZhi() %></td>
                <td><%=pro.getSaleNum() %></td>
            </tr>
            <%}%>
            </tbody>
            <tfoot>
            <tr>
                <td colspan=6 style="text-align: right">
                    <br/>
                    <form action="DoExcelServlet" method="post">
                        <input type="submit" value="打印Excel报表"
                               style="font-size: 12px; background-color: #FFBA75;" />
                    </form>
                </td>
            </tr>
            </tfoot>
        </table>
        <div style="text-align: center">
            首页&nbsp;&nbsp;上一页&nbsp;&nbsp;下一页&nbsp;&nbsp;末页
        </div>
    </div>
</div>
<!--右侧开始-->
<div class="sidebar">
    <div id="dome">
        <div id="dome1">

            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    大牌狂降价，三折直送
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    大学老师开网店
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    黑眼圈推荐，美白不停
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    瘦身狂潮风，修形之选
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    大牌狂降价，三折直送
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    大学老师开网店
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    黑眼圈推荐，美白不停
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    瘦身狂潮风，修形之选
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    大牌狂降价，三折直送
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    大学要求老师开网店
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    黑眼圈推荐，美白不停
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    瘦身狂潮风，修形之选
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    大牌狂降价，三折直送
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    大学老师开网店
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    黑眼圈推荐，美白不停
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    瘦身狂潮风，修形之选
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    黑眼圈推荐，美白不停
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    瘦身狂潮风，修形之选
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    大牌狂降价，三折直送
                </dd>
            </dl>

        </div>
        <div id="dome2"></div>
    </div>

    <!--TAB切换开始-->
    <div class="tab">
        <dl>
            <dt>
                <img src="<%=basePath%>/images/guimei/guimei_left1.jpg" alt="笔记本" id="left1" />
                <img src="<%=basePath%>/images/guimei/guimei_left2.jpg" alt="笔记本" id="left2"
                     onmouseover="change('top1')" style="display: none;" />
            </dt>
            <dt>
                <img src="<%=basePath%>/images/guimei/guimei_right1.jpg" alt="手机充值" id="right1"
                     onmouseover="change('top2')" />
                <img src="<%=basePath%>/images/guimei/guimei_right2.jpg" alt="手机充值" id="right2"
                     style="display: none;" />
            </dt>
        </dl>
        <dl>
            <dd>
                <img src="<%=basePath%>/images/guimei/guimei_end1.jpg" alt="笔记本" id="end1" />
                <img src="<%=basePath%>/images/guimei/guimei_end2.jpg" alt="手机充值" id="end2"
                     style="display: none;" />
            </dd>
        </dl>
    </div>
    <!--TAB切换结束-->
</div>
<!--中间的右侧内容结束-->
</div>
<!--网页版权部分开始-->
<div id="footer">
    <div class="copyright">
        友情链接：&nbsp;&nbsp;
        <a href="#">百度</a> |
        <a href="#">Google</a> |
        <a href="#">雅虎</a> |
        <a href="#">淘宝</a> |
        <a href="#">拍拍</a> |
        <a href="#">易趣</a> |
        <a href="#">当当</a> |
        <a href="#">京东商城</a> |
        <a href="#">迅雷</a> |
        <a href="#">新浪</a> |
        <a href="#">网易</a> |
        <a href="#">搜狐</a> |
        <a href="#">猫扑</a> |
        <a href="#">开心网</a> |
        <a href="#">新华网</a> |
        <a href="#">凤凰网</a>
        <br />
        <hr size="1" />
        COPYRIGHT &copy; 2003-2010
        <a href="#">北京市贵美商城有限公司</a> ALL RIGHT RESERVED
        <br />
        热线：400-66-13060 Email:service@prd.com
        <br />
        ICP：
        <a href="#">沪ICP备05021104号</a>
        <br />
        <img src="<%=basePath%>/images/guimei/guimei_copy_01.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_02.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_03.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_04.gif" alt="alt" />
    </div>
</div>
<!--网页版权部分结束-->

</body>
</html>





