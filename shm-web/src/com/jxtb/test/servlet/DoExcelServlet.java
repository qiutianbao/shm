package com.jxtb.test.servlet;

import com.jxtb.test.dao.ShoppingDao;
import com.jxtb.test.dao.ToExcelDao;
import com.jxtb.test.entity.Product;
import com.util.ExportExcelUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class DoExcelServlet extends HttpServlet {
    //导出
  /*  List<Map<String, String>> dataList;

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, String>> dataList) {
        this.dataList = dataList;
    }
*/

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       /* String sheetName="商品信息汇总表";
        String[] titles = { "商品ID", "商品名称", "单价(元)", "生产厂家", "保质期", "销售量" };

        response.setContentType("text/html;charset=utf-8");
        OutputStream os=response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        ToExcelDao toExcel=new ToExcelDao();
        ShoppingDao sd=new ShoppingDao();
        List<Product> list=sd.getAllProducts();
        toExcel.printToExcel(list,sheetName,titles,os);
        System.setOut(new PrintStream(os));
        os.flush();*/

        String exportType="商品信息汇总表";
        String title="商品信息汇总表";
        String[] titles = { "商品ID", "商品名称", "单价(元)", "生产厂家", "保质期", "销售量" };

        //导出
        ShoppingDao sd=new ShoppingDao();
        List<Map<String, String>> dataList=sd.getDataLists();
        System.out.println(dataList);
        String dataFieldNames[] = {"id","name","price","factory","baoZhi","saleNum"};

        try {
            //ExportExcelUtil.exportExcel(dataFieldNames, dataList, exportType, title, titles);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
