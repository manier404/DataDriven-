package org.test.maven.Maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class DateUtil {

	public static void main(String[] args) throws IOException {
		File loc = new File("C:\\Users\\Dell\\eclipse-workspace\\Selenium\\maven\\Maven1\\Excel\\Info.xls");
		FileInputStream str = new FileInputStream(loc);
		
		Workbook w = new HSSFWorkbook(str);
		
		org.apache.poi.ss.usermodel.Sheet s = w.getSheet("Details");
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			
			Row r = s.getRow(i);
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if (type== 1) {
					String name = c.getStringCellValue();
					System.out.println(name);
				}
					if (type==0) {
						
						if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(c)) {
							Date date = c.getDateCellValue();
							SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yy");
							String name = fr.format(date);
							System.out.println(name);
						}
						else {
							double d = c.getNumericCellValue();
							long l = (long)d;
							String name = String.valueOf(l);
							System.out.println(name);
					}
					
					}
				}
			}
			
	}
}

