package com.abcbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	
	//File file=new File(System.getProperty("user.dir")+"/ABCRetails/src/test/java/com/abcbanking/testData/LoginData.xlsx");
	
	
	
	
	
	
	public static int getRowcount(String xlfilepath,String xlsheet) throws IOException
	
	{
		
	fis=new FileInputStream(xlfilepath);
	
	//For Workbook
	wb=new XSSFWorkbook(fis);
	
	//For Worksheet in Workbook
	ws=wb.getSheet(xlsheet);
	//Get last row number
	int rowCount=ws.getLastRowNum();
	wb.close();
	fis.close();
	return rowCount;
		
	}
	
	//To find associated cell numbers in each row which gives column count
	public static int getCellCount(String xlfilepath, String xlsheet,int rownum) throws IOException
	
	{
		
		fis=new FileInputStream(xlfilepath);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	
	public static String getCellData(String xlfilepath,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlfilepath);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfilepath,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fis=new FileInputStream(xlfilepath);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfilepath);
		wb.write(fos);		
		wb.close();
		fis.close();
		fos.close();
	}
	
	

}
