package org.test.maven.Maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class Excels {
public static void main(String[] args) throws IOException {
	File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Selenium\\maven\\Maven1\\Excel\\Info.xls");
	
	FileInputStream str = new FileInputStream(loc);
	
	Workbook w = new HSSFWorkbook(str);
	
	org.apache.poi.ss.usermodel.Sheet s = w.getSheet("Details");
	
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		
		Row r = s.getRow(i);
		
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			
			Cell c = r.getCell(j);
			System.out.println(c);
			
}
	}
}
}