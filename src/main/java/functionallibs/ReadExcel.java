package functionallibs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Base.base;
 
//How to read excel files using Apache POI
public class ReadExcel extends base {
	
	@Test
 public void dataExcel() throws IOException{

		//prop.getProperty("excelpath")
 FileInputStream fs = new FileInputStream("F:\\Selenium\\TripPlannerNSW\\src\\main\\java\\testdata\\testdata.xlsx");
 XSSFWorkbook wb=new XSSFWorkbook(fs);
 XSSFSheet sheet=wb.getSheet("Sheet1") ;
 
 Iterator<Row>  rows= sheet.iterator();
 Row firstrow= rows.next();
 
 Iterator<Cell> ce=firstrow.cellIterator();
 

}
}