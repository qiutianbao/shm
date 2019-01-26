package com.util;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-28
 * Time: 下午4:49
 * To change this template use File | Settings | File Templates.
 */
public class ExportExcelUtil {

    private static final Log LOGGER = LogFactory.getLog(ExportExcelUtil.class);

    public static  String exportExcel(String[] dataFieldNames, List<Map<String, String>> dataList,
                                      String exportType, String title, String titles[]) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
       /*try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddhhmmss");
            exportType = simpledateformat.format(new Date());
        } catch (Exception ex) {
            LOGGER.debug("格式化日期错误 :");
        }*/
        //System.out.println(exportType.getBytes());
        response.reset();
        WritableWorkbook book = null;
        response.setContentType("application/x-msdownload; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(exportType.getBytes("UTF-8"),"ISO-8859-1") + ".xls\"");
        ServletOutputStream fileOut = null;

        try {

            WritableCellFormat wcfLeft = new WritableCellFormat();
            // 单元格对齐方式
            wcfLeft.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcfLeft.setAlignment(Alignment.LEFT);

            WritableCellFormat wcfCenter = new WritableCellFormat();
            wcfCenter.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcfCenter.setAlignment(Alignment.CENTRE);

            WritableCellFormat wcfRight = new WritableCellFormat();
            wcfRight.setVerticalAlignment(VerticalAlignment.CENTRE);
            wcfRight.setAlignment(Alignment.RIGHT);

            fileOut = response.getOutputStream();
            book = Workbook.createWorkbook(fileOut);
            WritableSheet sheet = book.createSheet(title, 0);// 标签页名，位置
            Label label = null; // 用于保存文本cell
            int titleRowCount = sheet.getRows(); // 记录表头占用几行

            // 写第一行 标题
            label = new Label(0, 0, title, wcfCenter);// 0列0行
            sheet.mergeCells(0, 0, titles.length-1, 0);// 合并0列0行到9列0行
            sheet.addCell(label);
            for (int i = 0; i < titles.length; i++) {
                label = new Label(i, 1, titles[i], wcfCenter);
                sheet.addCell(label);
            }

            titleRowCount = 2;

            // 往excel里写数据
            try {
                if (dataList != null) {
                    for (int i = 0; i < dataList.size(); i++) {// 数据共有多少行
                        for (int j = 0; j < dataFieldNames.length; j++) {// 数据列
                            Map<String, String> map = dataList.get(i);
                            String value = map.get(dataFieldNames[j]) != null ? map.get(dataFieldNames[j]).toString() : "--";
                            label = new Label(j + 1, i + titleRowCount, value, wcfRight);
                            sheet.addCell(label);
                        }
                        label = new Label(0, i + titleRowCount, i + 1 + "", wcfRight);
                        sheet.addCell(label);
                    }
                }
            } catch (RuntimeException e) {
                LOGGER.error(e.getLocalizedMessage());
            }

            book.write();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (book != null) {
                book.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        }
        return null;
    }

    /**
     * 生成excel并下载
     */
    public static void exportExcel(File file,HttpServletResponse response){

        //新文件写入数据，并下载*****************************************************
        InputStream is = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            is = new FileInputStream(file);
            workbook = new XSSFWorkbook(is);
            //获取第一个sheet
            sheet = workbook.getSheetAt(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if(sheet != null){
            try {
                //写数据
                FileOutputStream fos = new FileOutputStream(file);
                XSSFRow row = sheet.getRow(0);
                XSSFCell cell = row.getCell(1);
                System.out.println(cell.getStringCellValue());
                cell.setCellValue("ssssssssssssssssssssssssssssssssssssssssssss");
                workbook.write(fos);
                fos.flush();
                fos.close();

                //下载
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/x-msdownload");
                String newName = URLEncoder.encode("采购合同" + System.currentTimeMillis() + ".xls", "UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=\""+ newName + "\"");
                response.addHeader("Content-Length", "" + file.length());
                toClient.write(buffer);
                toClient.flush();
            }
            catch(Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if (null != is) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 生成excel并下载
     */
    public void exportExcel(HttpServletRequest request,HttpServletResponse response){

        File newFile = createNewFile(request);
        //File newFile = new File("d:/ss.xls");

        //新文件写入数据，并下载*****************************************************
        InputStream is = null;
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;
        try {
            is = new FileInputStream(newFile);
            workbook = new HSSFWorkbook(is);
            //获取第一个sheet
            sheet = workbook.getSheetAt(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if(sheet != null){
            try {
                //写数据
                FileOutputStream fos = new FileOutputStream(newFile);
                HSSFRow row = sheet.getRow(4);
                HSSFCell cell = row.getCell(1);
                System.out.println(cell.getStringCellValue());
                cell.setCellValue("ssssssssssssssssssssssssssssssssssssssssssss");
                workbook.write(fos);
                fos.flush();
                fos.close();

                //下载
                InputStream fis = new BufferedInputStream(new FileInputStream(newFile));

                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/x-msdownload");
                String newName = URLEncoder.encode("采购合同"+System.currentTimeMillis()+".xls", "UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=\""+ newName + "\"");
                response.addHeader("Content-Length", "" + newFile.length());
                toClient.write(buffer);
                toClient.flush();
            }
            catch(Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if (null != is) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //删除创建的新文件
        //this.deleteFile(newFile);
    }
    /**
     * 复制文件
     *
     * @param s
     * 源文件
     * @param t
     * 复制到的新文件
     */

    public void fileChannelCopy(File s, File t) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(s),1024);
                out = new BufferedOutputStream(new FileOutputStream(t),1024);
                byte[] buffer = new byte[1024];
                int len;
                while ((len=in.read(buffer))!=-1) {
                    out.write(buffer,0,len);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel模板，并复制到新文件中供写入和下载
     * @return
     */
    public File createNewFile(HttpServletRequest request){
        //读取模板，并赋值到新文件************************************************************
        //文件模板路径
        String path = request.getRealPath(SystemConfig.FILETEMPLATE);
        String fileName="purchaseContract.xls";
        File file=new File(path+"/"+fileName);

        //保存文件的路径
        String realPath = ServletActionContext.getServletContext().getRealPath(SystemConfig.UPLOAD_FILE_DIR);
        //新的文件名
        String newFileName = "采购合同"+System.currentTimeMillis() + ".xls";
        //判断路径是否存在
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //写入到新的excel
        File newFile = new File(realPath, newFileName);
        try {
            newFile.createNewFile();
            //复制模板到新文件
            fileChannelCopy(file, newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 下载成功后删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

}

