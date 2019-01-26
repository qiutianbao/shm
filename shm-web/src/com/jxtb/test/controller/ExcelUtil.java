package com.jxtb.test.controller;

import com.jxtb.test.entity.BaseResponse;
import com.jxtb.test.entity.UploadBondPos;
import com.jxtb.test.entity.UploadPosLog;
import com.jxtb.test.entity.UploadStockPos;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.Number;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-5
 * Time: 上午8:40
 * To change this template use File | Settings | File Templates.
 */
public class ExcelUtil {
    public static void exportData(List<HashMap<String, Object>> list, String path) {
        String[] title = {"编号", "姓名", "密码"};
        //1.创建一个工作簿对象
        WritableWorkbook wb = null;
        String fileName = path;
        File file = new File(fileName);
        try {
            wb = Workbook.createWorkbook(file);
            //2.创建工作表对象
            WritableSheet sheet = wb.createSheet("学生统计表", 0);
            //3.生成表头
            Label label = null;
            for (int i = 0; i < title.length; i++) {
                label = new Label(i, 0, title[i]);
                sheet.addCell(label);
            }
            //4.追加数据
            Label label1 = null;
            HashMap<String, Object> map = null;
            for (int i = 0; i < list.size(); i++) {
                map = list.get(i);
                //王第i+1行的第一列格子里追加数据
                label1 = new Label(0, i + 1, String.valueOf(map.get("id")));
                sheet.addCell(label1);

                label1 = new Label(1, i + 1, String.valueOf(map.get("name")));
                sheet.addCell(label1);

                label1 = new Label(2, i + 1, String.valueOf(map.get("pwd")));
                sheet.addCell(label1);
            }
            //写入数据
            wb.write();
            //关闭工作簿
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param args
     * @throws Exception
     * @author
     * @createtime 2015-7-31 上午09:58:41
     */
    public static void main(String[] args) throws Exception {
        //createExcel();
        //copeExcel();
        // readExcel();
        //read_excel();
    }

    public static void createExcel() throws Exception {
        String url = "D:\\excel\\javaExcel.xls";
        //创建文件
        OutputStream os = new FileOutputStream(url);
        WritableWorkbook wwb = Workbook.createWorkbook(os);
        //创建第一张sheet
        WritableSheet ws = wwb.createSheet("sheet1", 0);
        //添加label对象
        Label label = new Label(0, 0, "label cell");
        ws.addCell(label);
        //添加带有字型的label对象
        WritableFont wf = new WritableFont(WritableFont.TIMES, 18, WritableFont.BOLD, true);
        WritableCellFormat wcf = new WritableCellFormat(wf);
        Label labelwf = new Label(0, 1, "label cell 0 1", wcf);
        ws.addCell(labelwf);
        //添加带有字体颜色的label对象
        WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
        WritableCellFormat wcfc = new WritableCellFormat(wfc);
        Label labelwcfc = new Label(0, 2, "label cell 0 2", wcfc);
        ws.addCell(labelwcfc);
        //添加number,还有其他类型没有写
        Number labelN = new Number(0, 3, 2.1);
        ws.addCell(labelN);
        wwb.write();
        wwb.close();


    }

    public static void copeExcel() throws Exception {
        String url = "D:\\excel\\javaExcel1.xls";
        //创建文件
        OutputStream os = new FileOutputStream(url);
        WritableWorkbook wwb = Workbook.createWorkbook(os);
        //输入流文件路径读取
        InputStream in = new FileInputStream("D:\\excel\\javaExcel.xls");
        //构建workbook
        Workbook workBook = Workbook.getWorkbook(in);
        //获取读取文件的sheet数
        int sheet = workBook.getNumberOfSheets();
        for (int i = 0; i < sheet; i++) {
            //获取读取文件的sheet对象
            Sheet st = workBook.getSheet(i);
            //复制文件创建sheet对象
            WritableSheet ws = wwb.createSheet("sheet" + (i + 1), i);
            for (int j = 0; j < st.getColumns(); j++) {//循环读取文件的列
                for (int j2 = 0; j2 < st.getRows(); j2++) {//循环读取文件的行
                    Label label = new Label(j, j2, st.getCell(j, j2).getContents());//获取读取文件的值创建label
                    ws.addCell(label);//将label添加的复杂文件中
                }
            }
        }
        wwb.write();//写入
        wwb.close();//关闭
    }

    public static void readExcel() throws Exception {
        //输入流文件路径读取
        InputStream in = new FileInputStream("D:\\excel\\javaExcel.xls");
        //构建workbook
        Workbook workBook = Workbook.getWorkbook(in);
        //读取第一张sheet表
        Sheet st = workBook.getSheet(0);
        //读取第一行第一列
        Cell cell = st.getCell(0, 0);
        //将读取的excel数据转换成字符串
        String cellStr = cell.getContents();
        //读取第二行第一列
        Cell cell1 = st.getCell(st.getColumns() - 1 > 1 ? 1 : st.getColumns() - 1, 0);
        String cellStr1 = cell1.getContents();
        //读取第一行第二列
        Cell cell01 = st.getCell(0, st.getRows() - 1 > 1 ? 1 : st.getRows() - 1);
        String cellStr01 = cell01.getContents();
        System.out.println(cellStr + "|" + cellStr1 + "|" + cellStr01);
        //打印读取到的excel数据类型
        System.out.println(cell.getType());
        //获取sheet个数
        int sheetNumber = workBook.getNumberOfSheets();
        //获取sheet对象数组
        Sheet[] sheetArr = workBook.getSheets();
        //获取sheet的名称
        String sheetName = st.getName();
        //获取sheet表中的总列数
        int sheetColumn = st.getColumns();
        //获取某一列的单元格，返回数组对象
        Cell[] cellColumnArr = st.getColumn(0);
        //获取行数
        int sheetRow = st.getRows();
        //获取行下的单元格
        Cell[] cellRowArr = st.getRow(0);

        //操作完成关闭对象，释放占用的内存
        workBook.close();

    }

    public static void read_excel() {
        int i;
        Sheet sheet;
        Workbook book;
        Cell cell1, cell2, cell3;
        try {
            //t.xls为要读取的excel文件名
            book = Workbook.getWorkbook(new File("D:\\excel\\student.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0);
            //获取左上角的单元格
            cell1 = sheet.getCell(0, 0);
            System.out.println("标题：" + cell1.getContents());

            i = 1;
            while (true) {
                //获取每一行的单元格
                cell1 = sheet.getCell(0, i);//（列，行）
                cell2 = sheet.getCell(1, i);
                cell3 = sheet.getCell(2, i);
                if ("".equals(cell1.getContents()) == true)  //如果读取的数据为空
                    break;
                System.out.println(cell1.getContents() + "\t" + cell2.getContents() + "\t" + cell3.getContents());
                i++;
            }
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取xlsx文件
    public static List readExcelXlsx(FileInputStream filestream) throws Exception{
        boolean flag=false;
        List<UploadStockPos> uploadStockPosList=new ArrayList<>();
        List<UploadBondPos> uploadBondPosList=new ArrayList<>();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filestream);
        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(xssfWorkbook);
        // 获取每一个工作薄
        // 循环行Row
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);

                UploadPosLog uploadPosLog=new UploadPosLog();
                uploadPosLog.setGroup1(getXlsxValue(xssfRow.getCell(41), evaluator));

                if("Common Stock".equals(uploadPosLog.getGroup1())){
                    UploadStockPos uploadStockPos=new UploadStockPos();
                    uploadStockPos.setEnt_time(getXlsxValue(xssfRow.getCell(40), evaluator));
                    uploadStockPosList.add(uploadStockPos);
                    flag=true;
                }else{
                    UploadBondPos uploadBondPos=new UploadBondPos();
                    uploadBondPos.setEnt_time(getXlsxValue(xssfRow.getCell(40), evaluator));
                    uploadBondPosList.add(uploadBondPos);
                    flag=false;
                }

            }
        }
        if(flag){
            return uploadStockPosList;
        }else{
            return uploadBondPosList;
        }
    }

    //读取xls文件
    public static BaseResponse readExcelXls(FileInputStream filestream,BaseResponse baseResponse) throws Exception{
        List<UploadStockPos> uploadStockPosList=new ArrayList<>();
        List<UploadBondPos> uploadBondPosList=new ArrayList<>();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(filestream);
        HSSFFormulaEvaluator  evaluator = new HSSFFormulaEvaluator(hssfWorkbook);
        // 获取每一个工作薄
        // 循环行Row
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                baseResponse.setParam(hssfRow);
                baseResponse.setParam(evaluator);
             /*   UploadPosLog uploadPosLog=new UploadPosLog();
                uploadPosLog.setGroup1(getXlsValue(hssfRow.getCell(41), evaluator));
                if(uploadPosLog.getGroup1().indexOf("Stock")!=-1){
                    UploadStockPos uploadStockPos=new UploadStockPos();
                    uploadStockPos.setEnt_time(getXlsValue(hssfRow.getCell(40),evaluator));
                    uploadStockPosList.add(uploadStockPos);
                }else{
                    UploadBondPos uploadBondPos=new UploadBondPos();
                    uploadBondPos.setEnt_time(getXlsValue(hssfRow.getCell(40),evaluator));
                    uploadBondPosList.add(uploadBondPos);
                }*/
            }
        }

       return baseResponse;

    }

    //转换xlsx数据格式
    private static String getXlsxValue(XSSFCell cell,FormulaEvaluator evaluator) {
        if(cell==null){
            return "" ;
        }

        String value = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:                        //数值型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {       //如果是时间类型
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    value = format.format(cell.getDateCellValue());
                } else {                                            //纯数字
                    value = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:                         //字符串型
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:                        //布尔
                value = " " + cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:                          //空值
                value = "";
                break;
            case HSSFCell.CELL_TYPE_ERROR:                          //故障
                value = "";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:                        //公式型
                try {
                    CellValue cellValue;
                    cellValue = evaluator.evaluate(cell);
                    switch (cellValue.getCellType()) {              //判断公式类型
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:
                            value  = String.valueOf(cellValue.getBooleanValue());
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
                            // 处理日期
                            if (DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                                Date date = cell.getDateCellValue();
                                value = format.format(date);
                            } else {
                                value  = String.valueOf(cellValue.getNumberValue());
                            }
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                            value  = cellValue.getStringValue();
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK:
                            value = "";
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_ERROR:
                            value = "";
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:
                            value = "";
                            break;
                    }
                } catch (Exception e) {
                    value = cell.getStringCellValue().toString();
                    cell.getCellFormula();
                }
                break;
            default:
                value = cell.getStringCellValue().toString();
                break;
        }
        return value;
    }

    // 转换xls数据格式
    private static String getXlsValue(HSSFCell cell,FormulaEvaluator evaluator) throws Exception{
        if(cell==null){
            return "" ;
        }

        String value = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:                        //数值型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {       //如果是时间类型
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    value = format.format(cell.getDateCellValue());
                } else {                                            //纯数字
                    value = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:                         //字符串型
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:                        //布尔
                value = " " + cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:                          //空值
                value = "";
                break;
            case HSSFCell.CELL_TYPE_ERROR:                          //故障
                value = "";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:                        //公式型
                try {
                    CellValue cellValue;
                    cellValue = evaluator.evaluate(cell);
                    switch (cellValue.getCellType()) {              //判断公式类型
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:
                            value  = String.valueOf(cellValue.getBooleanValue());
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
                            // 处理日期
                            if (DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                                Date date = cell.getDateCellValue();
                                value = format.format(date);
                            } else {
                                value  = String.valueOf(cellValue.getNumberValue());
                            }
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                            value  = cellValue.getStringValue();
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK:
                            value = "";
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_ERROR:
                            value = "";
                            break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:
                            value = "";
                            break;
                    }
                } catch (Exception e) {
                    value = cell.getStringCellValue().toString();
                    cell.getCellFormula();
                }
                break;
            default:
                value = cell.getStringCellValue().toString();
                break;
        }
        return value;
    }


}
