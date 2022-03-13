package Datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excelutility {

	public static WebDriver driver;

	public static XSSFWorkbook wb;
	public static XSSFRow row;
	public static XSSFCell ce;
	public static XSSFSheet sheet;
	public static FileInputStream fis;

	public static File file = new File("E:\\sagar\\testdata.xlsx");

	public String read(String nameofsheet, int row1, int cell) throws IOException {

		fis = new FileInputStream(file);

		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet(nameofsheet);
		row = sheet.getRow(row1);

		ce = row.getCell(cell);

		String value = ce.getStringCellValue();

		return value;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
