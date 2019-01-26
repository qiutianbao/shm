package com.core.support;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.Action;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 上午11:35
 * action类的基类，内部定义了action类的一些公用的方法和属性，用于被业务类继承
 * struts2
 */
@SuppressWarnings("ALL")
public class BaseActionSupport extends ActionSupport {
    private static final long serialVersionUID = 5437809463727133151L;
    protected String basePath = "";
    // 分页
    protected int currentPage = 1;
    protected int pageSize = 10;  //每页记录数
    protected int totalPage = 1;  //初始记录总数
    protected int totalRows = 1;// 总记录数
    protected int loadcount = 8;
    protected String pageAmount;
    private Document dom;

    public String PAGE = "page"; // 返回分页标签
    public String DATA = "data"; // 返回数据页面

    public String id;
    public List<Map<String, Object>> paramList;
    public Map<String, Object> paramMap; //页面返回
    public Integer starRow;
    public Integer endRow;

    public String paramName;

    /**
     * @fields LOGGER:日志对象
     */
    public static Logger LOGGER = Logger.getLogger(BaseActionSupport.class);

    /**
     * @fields CURRENT_USER:当前用户
     */
    public static final String CURRENT_USER = "CURRENT_USER";

    /**
     * @fields ACTION_ERRORS: 常用业务扭转类型定义，出错
     */
    public static final String ACTION_ERRORS = "actionErrors";

    /**
     * @fields CREATE: 常用业务扭转类型定义，创建
     */
    public static final String CREATE = "create";

    /**
     * @fields EDIT: 常用业务扭转类型定义，编辑
     */
    public static final String EDIT = "edit";

    /**
     * @fields UPDATE: 常用业务扭转类型定义，更新
     */
    public static final String UPDATE = "update";

    /**
     * @fields DELETE:常用业务扭转类型定义，删除
     */
    public static final String DELETE = "delete";

    /**
     * @fields SELECT:常用业务扭转类型定义，选择
     */
    public static final String SELECT = "select";

    /**
     * @fields VOUCH:常用业务扭转类型定义，更新
     */
    public static final String VOUCH = "vouch";

    /**
     * @fields INFO:常用业务扭转类型定义，信息
     */
    public static final String INFO = "info";

    /**
     * @fields WARN:常用业务扭转类型定义，警告
     */
    public static final String WARN = "warn";

    /**
     * @fields OPEN:常用业务扭转类型定义，打开
     */
    public static final String OPEN = "open";

    /**
     * @fields NO_PERMISSION:常用业务扭转类型定义，没有权限
     */
    public static final String NO_PERMISSION = "noPermission";

    /**
     * @fields LOGIN:常用业务扭转类型定义，已登陆
     */
    public static final String LOGIN = Action.LOGIN;

    /**
     * @fields NO_LOGIN:常用业务扭转类型定义，未登陆
     */
    public static final String NO_LOGIN = "noLogin";

    /**
     * @fields EXCEL:常用业务扭转类型定义，生成Excel
     */
    public static final String EXCEL = "expExcel";

    /**
     * @fields action: 属性变量
     */
    private String action;

    /**
     * @fields actionMessage:属性变量
     */
    private String actionMessage;
    /**
     * @fields warnMessage: 警告信息
     */
    private String warnMessage;

    /**
     * @fields start:属性变量
     */
    protected int start;

    public String queryCommonPage() {
        totalPage = (totalRows + pageSize - 1) / pageSize;
        return SUCCESS;
    }

    public void setTotalPage(int totalPage) {
        if (totalPage < 1) {
            totalPage = 1;
        }
        this.totalPage = totalPage;
    }

    /*
     * 条数设置
     */
    protected void setCount(Map<String, Object> map) {
        int start = (currentPage - 1) * loadcount + 1;
        int end = currentPage * loadcount;
        map.put("start", start);
        map.put("end", end);
    }

    /*
     * 加入分页条件
     */
    protected void addPageInfo(Map<String, Object> map) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        map.put("start", start);
        map.put("end", end);
    }

    /**
     * 根据属性参数，从web service返回的xml文件中取得相应的属性值
     *
     * @param document
     * @param property 属性名 有：id--responseId,
     *                 rows--添加、删除、修改的记录数,records--这次返回的记录数,totalrows--查询到的总的记录数（一般是指分页查询时，总的记录数)
     * @return
     */
    public static String parsePropertyFromResponseXml(Document document, String property) {
        List resultList = new ArrayList();
        try {
            if (document != null) {
                NodeList resultNodeList = document.getElementsByTagName("result");
                if (resultNodeList != null && resultNodeList.getLength() > 0) {
                    // 循环每一个result
                    for (int i = 0; i < resultNodeList.getLength(); i++) {

                        Node resultNode = resultNodeList.item(i);

                        // 取得他的属性
                        NamedNodeMap attrList = resultNode.getAttributes();

                        for (int j = 0; j < attrList.getLength(); j++) {
                            Node attr = attrList.item(j);
                            String attrName = attr.getNodeName();
                            String attrValue = attr.getNodeValue();
                            if ("id".equals(attrName)) {

                                if (property.equalsIgnoreCase("id")) {
                                    return attrValue;
                                }

                            }
                            // 如果有这个属性时，表示是删除、修改、添加操作反应的response，则下面的不用解析
                            if ("rows".equals(attrName)) {
                                if (property.equalsIgnoreCase("rows")) {
                                    return attrValue;
                                }

                            }

                        }

                        // 取result下面的子节点

                        NodeList rowsNodeList = resultNode.getChildNodes();
                        // System.out.println("resultNode.childNodes="+rowsNodeList.getLength());

                        for (int m = 0; m < rowsNodeList.getLength(); m++) {
                            Node rowsNode = rowsNodeList.item(m);
                            String nodeName = rowsNode.getNodeName();

                            if (nodeName.equalsIgnoreCase("rows")) {
                                NamedNodeMap rowsAttrList = rowsNode.getAttributes();
                                for (int j = 0; j < rowsAttrList.getLength(); j++) {
                                    Node attr = rowsAttrList.item(j);
                                    String attrName = attr.getNodeName();
                                    String attrValue = attr.getNodeValue();

                                    if ("records".equals(attrName)) {
                                        if (property.equalsIgnoreCase("records")) {
                                            return attrValue;
                                        }

                                    }
                                    if ("totalrows".equals(attrName)) {
                                        if (property.equalsIgnoreCase("totalrows")) {
                                            return attrValue;
                                        }

                                    }
                                }

                                // System.out.println("---resultList.size--="+resultList.size());
                            }
                            return null;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * @param text
     * @return 参数说明
     * @title: writeResponse
     * @description:直接输出内容的简便函数.
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String writeResponse(String text) {
        PrintWriter out = null;
        try {
            HttpServletResponse response = this.getResponse();
            response.setContentType("text/html;charset=utf-8");
            out = response.getWriter();
            out.write(text);
        } catch (IOException e) {
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return null;
    }


    /**
     * clob字段jsp页面显示处理
     *
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public String clobToString(oracle.sql.CLOB clob) {
        String newstring = null;
        try {
            if (clob == null) {
                return newstring;
            }
            Reader inStream = clob.getCharacterStream();
            char[] c = new char[(int) clob.length()];
            inStream.read(c);
            String data = new String(c);
            inStream.close();
            if (data != null && !("").equals(data)) {
                newstring = data;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        newstring = newstring.replaceAll("(\r\n|\r|\n|\n\r)", "<br/>").replaceAll("<br/>", "</p><p>").replaceAll("</p><p></p><p>", "</p><p>").replaceAll("　", "");
        return newstring;
    }

    /**
     * @return 返回一个http request请求对象
     * @title: getRequest
     * @description:得到request请求对象
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * @return 返回一个http response请求对象
     * @title: getResponse
     * @description:得到response请求对象
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * @return 返回cookies对象
     * @title: getCookies
     * @description:得到cookies对象
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected Cookie[] getCookies() {
        return ServletActionContext.getRequest().getCookies();
    }

    /**
     * @return 返回session对象
     * @title: getSession
     * @description:得到session对象
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * @param parameter 参数名
     * @return int型的数值
     * @title: getIntParameter
     * @description:从request中取得整型参数的值
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected int getIntParameter(String parameter) {
        Object value = getRequest().getParameter(parameter);
        if (value != null) {
            try {
                return Integer.parseInt(((String[]) value)[0]);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    /**
     * @param parameter
     * @return request参数的String数组
     * @title: getParameterValues
     * @description:取得request中的所有参数，以String数组返回
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String[] getParameterValues(String parameter) {
        String[] values = this.getRequest().getParameterValues(parameter);
        if (values != null) {
            return values;
        }
        return new String[]{};
    }

    /**
     * @param text
     * @param contentType
     * @return 参数说明
     * @title: render
     * @description:绕过Template,直接输出内容的简便函数.
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String render(String text, String contentType) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType(contentType);
            response.getWriter().write(text);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param text 文本字符串
     * @return 参数说明
     * @title: renderText
     * @description: response直接输出文本字符串.
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String renderText(String text) {
        return render(text, "text/plain;charset=UTF-8");
    }

    /**
     * @param jsonScript
     * @return 参数说明
     * @title: renderJson
     * @description: response直接输出json字符串
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String renderJson(String jsonScript) {
        return render(jsonScript, "application/json;charset=UTF-8");
    }

    /**
     * @param html
     * @return 参数说明
     * @title: renderHtml
     * @description: response直接输出HTML.
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String renderHtml(String html) {
        return render(html, "text/html;charset=UTF-8");
    }

    /**
     * @param xml
     * @return 参数说明
     * @title: renderXML
     * @description: response直接输出XML.
     * @version Ver 1.0
     * @since Ver 1.0
     */
    protected String renderXML(String xml) {
        return render(xml, "text/xml;charset=UTF-8");
    }

    /**
     * @return the action
     */

    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the actionMessage
     */

    public String getActionMessage() {
        return actionMessage;
    }

    /**
     * @param actionMessage the actionMessage to set
     */

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    /**
     * @return the warnMessage
     */

    public String getWarnMessage() {
        return warnMessage;
    }

    /**
     * @param warnMessage the warnMessage to set
     */

    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }

    /**
     * @return the start
     */

    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */

    public void setStart(int start) {
        this.start = start;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public Document getDom() {
        return dom;
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }

    public String getBasePath() {
        return basePath;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, Object>> getParamList() {
        return paramList;
    }

    public void setParamList(List<Map<String, Object>> paramList) {
        this.paramList = paramList;
    }

    public Integer getStarRow() {
        return (currentPage - 1) * pageSize;
    }

    public Integer getEndRow() {
        return currentPage * pageSize;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(String pageAmount) {
        this.pageAmount = pageAmount;
    }
}

