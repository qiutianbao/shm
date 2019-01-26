package com.page;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-29
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public class PageUtil {
    private int pageIndex = 1;
    private int count = 1;
    private int pageSize = 10;
    private int totalPage = 0;

    private String errorcode;
    private String root;
    private List<Map<String, Object>> activityLists;

    public PageUtil() {
    }
    public PageUtil(String root) {
        this.root = root;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        if (pageIndex <= 0)
            this.pageIndex = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        if (count <= 0) {
            totalPage = 0;
        }
        totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (pageSize <= 0)
            pageSize = 5;
        if (count > 0)
            totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<Map<String, Object>> getActivityLists() {
        return activityLists;
    }

    public void setActivityLists(List<Map<String, Object>> activityLists) {
        this.activityLists = activityLists;
    }
}

