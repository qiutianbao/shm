package com.jxtb.test.dao;

import java.io.OutputStream;
import java.util.List;


import com.jxtb.test.entity.Product;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 操作Excel
 * */
public class ToExcelDao {
    // 打开文件
    Workbook wb=new HSSFWorkbook();

    //设置标题行格式
    public CellStyle titleStyle(){
        CellStyle style1=wb.createCellStyle();
        style1.setAlignment(CellStyle.ALIGN_CENTER);
        style1.setFillForegroundColor(HSSFColor.YELLOW.index);
        style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        Font font=wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.BLUE.index);
        style1.setFont(font);
        style1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
        return style1;
    }

    //设置行内容格式
    public CellStyle beautiful(int i){
        CellStyle style1=wb.createCellStyle();
        style1.setAlignment(CellStyle.ALIGN_CENTER);
        if(i%2!=0){
            style1.setFillForegroundColor(HSSFColor.YELLOW.index);
            style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        }
        style1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
        style1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
        return style1;
    }

    // 输出集合信息到Excel中
    public void printToExcel(List<Product> list,String sheetName,String titles[],OutputStream os) {
        try {
            // 生成名为“商品信息汇总”的工作表，参数0表示这是第一页
            Sheet sheet=wb.createSheet(sheetName);

            Row titleRow=sheet.createRow(0);

            // 标题信息
            for (int i = 0; i < titles.length; i++) {
                Cell cell=titleRow.createCell(i);
                cell.setCellValue(titles[i]);
                cell.setCellStyle(this.titleStyle());
                //设置列宽
                sheet.setColumnWidth(i, 4000);
            }

            Cell cell=null;
            // 商品信息,其中商品单价以及销售量两列为数值形式，以"n"开头作为标记，将这两列数据插入Excel时进行数值格式的装换
            for (int j = 0; j < list.size(); j++) {
                Product product = list.get(j);
                Row row=sheet.createRow(j+1);
                String[] cellContents = { product.getId(),
                        product.getName(), "n"+product.getPrice(),
                        product.getFactory(), product.getBaoZhi(),
                        "n"+ product.getSaleNum() };

                for (int i = 0; i < cellContents.length; i++) {
                    String content = cellContents[i];
                    cell=row.createCell(i);
                    if (content.startsWith("n")) {
                        // 数值格式的单元格要进行格式转换
                        double price = Double.parseDouble(content.substring(1));
                        cell.setCellValue(price);
                    } else{
                        cell.setCellValue(content);
                    }
                    cell.setCellStyle(this.beautiful(j));
                }
            }
            wb.write(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

}
