package com.jxtb.test.controller;

import com.jxtb.test.entity.BaseResponse;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-5
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ExcelController {
    @RequestMapping("upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, BiffException, WriteException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mRequest.getFile("file");
        FileInputStream filestream=(FileInputStream) file.getInputStream();
      /*  XSSFWorkbook workbook = new XSSFWorkbook(filestream);
        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(workbook);

        // 只需要读第一个工作表，不用循环
        XSSFSheet sheet = workbook.getSheetAt(0);
        String sheetname = sheet.getSheetName();

        for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {//获取每行
            XSSFRow row = sheet.getRow(j);

        }*/

        //构建workbook
        Workbook workBook=Workbook.getWorkbook(filestream);
        //读取第一张sheet表
        Sheet st=workBook.getSheet(0);
        //读取第一行第一列
        Cell cell=st.getCell(0, 0);
        //将读取的excel数据转换成字符串
        String cellStr=cell.getContents();
        //读取第二行第一列
        Cell cell1=st.getCell(st.getColumns()-1>1?1:st.getColumns()-1, 0);
        String cellStr1=cell1.getContents();
        //读取第一行第二列
        Cell cell01=st.getCell(0, st.getRows()-1>1?1:st.getRows()-1);
        String cellStr01=cell01.getContents();
        System.out.println(cellStr+"|"+cellStr1+"|"+cellStr01);
        //打印读取到的excel数据类型
        System.out.println(cell.getType());
        //获取sheet个数
        int sheetNumber=workBook.getNumberOfSheets();
        //获取sheet对象数组
        Sheet[] sheetArr=workBook.getSheets();
        //获取sheet的名称
        String sheetName=st.getName();
        //获取sheet表中的总列数
        int sheetColumn=st.getColumns();
        //获取某一列的单元格，返回数组对象
        Cell[] cellColumnArr=st.getColumn(0);
        //获取行数
        int sheetRow=st.getRows();
        //获取行下的单元格
        Cell[] cellRowArr=st.getRow(0);

        //操作完成关闭对象，释放占用的内存
        workBook.close();
    }


    @RequestMapping("leadingInUpload")
    public void leadingInUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mRequest.getFile("file");
        FileInputStream filestream=(FileInputStream) file.getInputStream();
        String fileName=null;

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile files = multiRequest.getFile((String) iter.next());
                if (files != null) {
                    fileName = files.getOriginalFilename();
                }
            }
        }

        BaseResponse baseResponse=new BaseResponse();
        List list=null;
        if(fileName.endsWith(".xls")){
            baseResponse= ExcelUtil.readExcelXls(filestream,baseResponse);
        }else if(fileName.endsWith(".xlsx")){
            list= ExcelUtil.readExcelXlsx(filestream);
        }
        System.out.println(baseResponse.getParam());
    }

}
