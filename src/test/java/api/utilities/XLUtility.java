package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	int i;
	int j;
	public XLUtility(String path)
	{
		this.path=path;
	}
//	public int getRowCount(String sheetName) throws IOException
//	{
//		fi=new FileInputStream(path);
//		workbook = new XSSFWorkbook(fi);
//		sheet=workbook.getSheet(sheetName);
//		int rowcount=sheet.getLastRowNum();
//		workbook.close();
//		fi.close();
//		return rowcount;
//	}
	public int getRowCount(String sheetName) {
	    int rowCount = 0;
	    try {
	        FileInputStream file = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        rowCount = sheet.getLastRowNum();
	        workbook.close();
	        file.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return rowCount;
	}
	public int getCellCount(String sheetName, int rowNum) {
	    int cellCount = 0;
	    try {
	        FileInputStream file = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(rowNum);
	        cellCount = row.getLastCellNum();
	        workbook.close();
	        file.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) {
	    String data = "";
	    try {
	        FileInputStream file = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(rowNum);
	        XSSFCell cell = row.getCell(colNum);
	        DataFormatter formatter = new DataFormatter();
	        data = formatter.formatCellValue(cell);
	        workbook.close();
	        file.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return data;
	}

}
	
