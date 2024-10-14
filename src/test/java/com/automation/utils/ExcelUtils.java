package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/Credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        for (int i=0;i<sheet.getLastRowNum();++i) {
            XSSFRow row = sheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();++j) {
                System.out.print(row.getCell(j).getStringCellValue() + " ");
            }
            System.out.println();
        }
    }
}
