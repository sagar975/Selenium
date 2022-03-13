package com.automationpractise.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	public static File file;
	public static FileInputStream input;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	@Test
	public static void readExcel() throws IOException {

		file = new File("C:\\SeleniumCloned\\Selenium\\SeleniumE2E\\DataSource\\TestData.xlsx");
		try {
			input = new FileInputStream(file);
			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheetAt(0);
			String othrow = sheet.getRow(1).getCell(0).getStringCellValue();
			int lastrow = sheet.getLastRowNum();
			System.out.println(lastrow);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
