package mess.wkb.cm.tool.util.file;



import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;





public class ExcelExport {
	
	/**
	 * 导出excel 
	 * @param title  文件名
	 * @param headStr  第一列 列头 （顺序与数据列需要一致）
	 * @param data （数据）
	 * @return
	 */
	public String outExcel(String title, String[] headStr, List<String[]> data){
		
		HSSFWorkbook wb = new HSSFWorkbook(); 
		HSSFSheet sheet = wb.createSheet(title); 
		
		sheet.setColumnWidth((short)3, 20* 256);    
		sheet.setDefaultRowHeight((short)100);  
		
		//样式1
		HSSFCellStyle style = wb.createCellStyle(); // 样式对象
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		
		//设置标题字体格式 设置字体样式 
		Font font = wb.createFont();   
		font.setFontHeightInPoints((short)20);   //--->设置字体大小
		font.setFontName("Courier New");   //---》设置字体，是什么类型例如：宋体

		//创作第一行
		int cloumnInt = headStr.length;
		HSSFRow row1 = sheet.createRow(0); 
		row1.setHeightInPoints(25);
		HSSFCell cell = null;
		for(int i = 0 ; i < cloumnInt ;i++){
			cell = row1.createCell(i);  
			cell.setCellStyle(style);
			cell.setCellValue(String.valueOf(headStr[i]));
		}
		
		//搞内容行
		String[] rData = null;
		HSSFRow row = null;
		for(int r = 0 ; r<data.size();r++){
			row = sheet.createRow(r+1);
			row.setHeightInPoints(25);
			rData = data.get(r);
			for(int i = 0 ; i < cloumnInt ; i++){
				cell = row.createCell(i); 
				cell.setCellStyle(style);
				cell.setCellValue(rData[i]);
			}
		}
		
		FileOutputStream fileOut = null;  
		String fileName = null ; //SysConfig.EXCEL_PATH + title + "_" + System.currentTimeMillis()+".xls";
        try {              
            fileOut = new FileOutputStream(fileName);  
            wb.write(fileOut);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        finally{  
            if(fileOut != null){  
                try {  
                    fileOut.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
		return fileName;
	}
	
}
