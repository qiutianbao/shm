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

    <title>�����̳���ҳ</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<%=basePath%>/css/guimei/busywork_guimei.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
    //��ȡ������Ʒ��Ϣ����
    int i=0;
    ShoppingDao shopping=new ShoppingDao();
    List<Product> products=shopping.getAllProducts();
%>
<script src="<%=path%>/js/ajax/busywork_guimei.js" type="text/javascript"></script>
<!--��ҳ�������ֿ�ʼ-->
<div id="header">
    <div class="header_top">
        <ul>
            <li class="pic pic1"></li>
            <li class="top_menu_text ">
                <a href="#">���ﳵ</a>
            </li>
            <li class="pic pic2"></li>
            <li class="top_menu_text">
                <a href="#">��������</a>
            </li>
            <li class="pic pic3"></li>
            <li class="top_menu_text">
                <a href="javascript:addCookie()">�����ղ�</a>
            </li>
            <li class="pic pic4"></li>
            <li class="top_menu_text">
                <a href="javascript:setHomePages()">��Ϊ��ҳ</a>
            </li>
            <li class="pic btn">
                <a href="#">��¼</a>
            </li>
            <li class="pic btn">
                <a href="#">ע��</a>
            </li>
        </ul>
    </div>
    <div class="header_middle" id="header_middle">
        <script type="text/javascript">time()</script>
    </div>
    <div class="nav">
        <ul>
            <li>
                <a href="#">&nbsp;��&nbsp;&nbsp;&nbsp;ҳ&nbsp;</a>
            </li>
            <li>
                <a href="#">���õ���</a>
            </li>
            <li>
                <a href="#">�ֻ�����</a>
            </li>
            <li>
                <a href="#">���ðٻ�</a>
            </li>
            <li>
                <a href="#">&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;</a>
            </li>
            <li>
                <a href="#">��������</a>
            </li>
            <li>
                <a href="#">��ѿ���</a>
            </li>
            <li>
                <a href="#">���۹���</a>
            </li>
        </ul>
    </div>
</div>
<!--��ҳ�м䲿�ֿ�ʼ-->
<div id="main">
<!--����˵���ʼ-->
<div class="cat">
    <ul id="cat_menu">
        <!--
���˵�ʹ�ô�HTMLʵ�ֵĴ������£�
<li class="cat_class">���õ���</li>
<li class="cat_li">��ҵ�</li>
......
<li class="cat_li">�����</li>
<li class="cat_class">�鼮</li>
<li class="cat_li">��ѧ</li>
......
<li class="cat_li">����</li>
<li class="cat_class">�ֻ�����</li>
<li class="cat_li">��������</li>
......
<li class="cat_li">����</li>
<li class="cat_class">���ðٻ�</li>
<li class="cat_li">��ͯ��Ʒ</li>
......
<li class="cat_li">����</li>

����ʹ��JavaScript����ʵ��
-->
        <script type="text/javascript">menu()</script>
    </ul>
</div>
<!--�м���ͷ���￪ʼ-->
<div class="content">
    <!--����ť�ĺ����濪ʼ-->
    <div class="adRotator">
        <img src="<%=basePath%>/images/guimei/guimei_ad-01.jpg" alt="scroll" id="adverImg" />
        <div class="number_bg">
            <a href="javascript:adver(1)" class="advers">1</a>
            <a href="javascript:adver(2)" class="advers">2</a>
            <a href="javascript:adver(3)" class="advers">3</a>
            <a href="javascript:adver(4)" class="advers">4</a>
        </div>
    </div>
    <!--����￪ʼ-->
    <div style="width: 524px;">
        <table border="0" cellpadding="1" cellspacing="1"
               style="text-align: center; margin: 0 auto; border-color: gray; width: 524px;">
            <thead>
            <tr
                    style="font-weight: bold; background: #FFBA75; text-align: center">
                <td class="top_menu_text ">
                    ��ƷID
                </td>
                <td class="top_menu_text ">
                    ��Ʒ����
                </td>
                <td class="top_menu_text ">
                    ���ۣ�Ԫ��
                </td>
                <td class="top_menu_text ">
                    ��������
                </td>
                <td class="top_menu_text ">
                    ������
                </td>
                <td class="top_menu_text ">
                    ������
                </td>
            </tr>
            </thead>
            <tbody>
            <%
                //���б�ɫ
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
                        <input type="submit" value="��ӡExcel����"
                               style="font-size: 12px; background-color: #FFBA75;" />
                    </form>
                </td>
            </tr>
            </tfoot>
        </table>
        <div style="text-align: center">
            ��ҳ&nbsp;&nbsp;��һҳ&nbsp;&nbsp;��һҳ&nbsp;&nbsp;ĩҳ
        </div>
    </div>
</div>
<!--�Ҳ࿪ʼ-->
<div class="sidebar">
    <div id="dome">
        <div id="dome1">

            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    ���ƿ񽵼ۣ�����ֱ��
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    ��ѧ��ʦ������
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����Ȧ�Ƽ������ײ�ͣ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����񳱷磬����֮ѡ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    ���ƿ񽵼ۣ�����ֱ��
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    ��ѧ��ʦ������
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����Ȧ�Ƽ������ײ�ͣ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����񳱷磬����֮ѡ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    ���ƿ񽵼ۣ�����ֱ��
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    ��ѧҪ����ʦ������
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����Ȧ�Ƽ������ײ�ͣ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����񳱷磬����֮ѡ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    ���ƿ񽵼ۣ�����ֱ��
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_02.jpg" alt="scroll" />
                </dt>
                <dd>
                    ��ѧ��ʦ������
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����Ȧ�Ƽ������ײ�ͣ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����񳱷磬����֮ѡ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_03.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����Ȧ�Ƽ������ײ�ͣ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_04.jpg" alt="scroll" />
                </dt>
                <dd>
                    ����񳱷磬����֮ѡ
                </dd>
            </dl>
            <dl>
                <dt>
                    <img src="<%=basePath%>/images/guimei/guimei_scroll_01.jpg" alt="scroll" />
                </dt>
                <dd>
                    ���ƿ񽵼ۣ�����ֱ��
                </dd>
            </dl>

        </div>
        <div id="dome2"></div>
    </div>

    <!--TAB�л���ʼ-->
    <div class="tab">
        <dl>
            <dt>
                <img src="<%=basePath%>/images/guimei/guimei_left1.jpg" alt="�ʼǱ�" id="left1" />
                <img src="<%=basePath%>/images/guimei/guimei_left2.jpg" alt="�ʼǱ�" id="left2"
                     onmouseover="change('top1')" style="display: none;" />
            </dt>
            <dt>
                <img src="<%=basePath%>/images/guimei/guimei_right1.jpg" alt="�ֻ���ֵ" id="right1"
                     onmouseover="change('top2')" />
                <img src="<%=basePath%>/images/guimei/guimei_right2.jpg" alt="�ֻ���ֵ" id="right2"
                     style="display: none;" />
            </dt>
        </dl>
        <dl>
            <dd>
                <img src="<%=basePath%>/images/guimei/guimei_end1.jpg" alt="�ʼǱ�" id="end1" />
                <img src="<%=basePath%>/images/guimei/guimei_end2.jpg" alt="�ֻ���ֵ" id="end2"
                     style="display: none;" />
            </dd>
        </dl>
    </div>
    <!--TAB�л�����-->
</div>
<!--�м���Ҳ����ݽ���-->
</div>
<!--��ҳ��Ȩ���ֿ�ʼ-->
<div id="footer">
    <div class="copyright">
        �������ӣ�&nbsp;&nbsp;
        <a href="#">�ٶ�</a> |
        <a href="#">Google</a> |
        <a href="#">�Ż�</a> |
        <a href="#">�Ա�</a> |
        <a href="#">����</a> |
        <a href="#">��Ȥ</a> |
        <a href="#">����</a> |
        <a href="#">�����̳�</a> |
        <a href="#">Ѹ��</a> |
        <a href="#">����</a> |
        <a href="#">����</a> |
        <a href="#">�Ѻ�</a> |
        <a href="#">è��</a> |
        <a href="#">������</a> |
        <a href="#">�»���</a> |
        <a href="#">�����</a>
        <br />
        <hr size="1" />
        COPYRIGHT &copy; 2003-2010
        <a href="#">�����й����̳����޹�˾</a> ALL RIGHT RESERVED
        <br />
        ���ߣ�400-66-13060 Email:service@prd.com
        <br />
        ICP��
        <a href="#">��ICP��05021104��</a>
        <br />
        <img src="<%=basePath%>/images/guimei/guimei_copy_01.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_02.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_03.gif" alt="alt" />
        <img src="<%=basePath%>/images/guimei/guimei_copy_04.gif" alt="alt" />
    </div>
</div>
<!--��ҳ��Ȩ���ֽ���-->

</body>
</html>





