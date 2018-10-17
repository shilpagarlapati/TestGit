package functionallibs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Base.base;
import objectrepository.TripPlannerPage;
 

public class functionlib extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	TripPlannerPage TP=new TripPlannerPage(driver);
	@Test
	public String TimeWithoutDate() {
		  final long CURRENT_TIME_MILLIS = System.currentTimeMillis();
		     // Convert the milliseconds since the epoch into a
		     Date instant = new Date(CURRENT_TIME_MILLIS);
		     SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
		     String time = sdf.format( instant );
		     return time;
		  }
	
	@Test
	public void validateSearchResults(){
		log.info("Validating search results");
		List<WebElement> st= (List<WebElement>) TP.resultDisplay();
		if (st.size()>0){
			int noofresults=st.size();
			log.info(noofresults +" results are found");
		}
		else {
		log.info("no search results found please refine your search");
			
		}
	}
		
}