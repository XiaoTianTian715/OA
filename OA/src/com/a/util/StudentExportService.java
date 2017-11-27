package com.a.util;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import com.a.bean.News;

public class StudentExportService { 
	
	
	  
    String[] excelHeader = { "编号", "新闻标题" ,"新闻内容", "发布人","类别编号", "审核状态","发布时间"};  
    public HSSFWorkbook export(List<News> list) {  
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("News");  
        HSSFRow row = sheet.createRow(0);  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(CellStyle.ALIGN_CENTER);  
  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            cell.setCellType(Cell.CELL_TYPE_STRING);
            sheet.autoSizeColumn(i);  
        }  
       
      
  
        for (int i = 0; i < list.size(); i++) {
        	
            row = sheet.createRow(i + 1);  
            News news = list.get(i); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            String dateString = formatter.format(news.getPbTime());

            row.createCell(0).setCellValue(news.getNewsid());  
            row.createCell(1).setCellValue(news.getTitle());
            row.createCell(2).setCellValue(news.getContent());     
            row.createCell(3).setCellValue(news.getPbperson());  
            row.createCell(4).setCellValue(news.getClassid());  
            row.createCell(5).setCellValue(news.getState());  
            row.createCell(6).setCellValue(dateString);
            
        }  
        return wb;  
    }  
}  