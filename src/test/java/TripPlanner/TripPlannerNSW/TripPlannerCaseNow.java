package TripPlanner.TripPlannerNSW;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.base;
import functionallibs.functionlib;
import objectrepository.TripPlannerPage;

class TripPlannerCaseNow extends base {
	
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	functionlib fl=new functionlib();
	TripPlannerPage TP= new TripPlannerPage(driver);
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String From, String To, String Time) throws IOException, InterruptedException{
		driver=initializeDriver();
		log.info("driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		WebDriverWait wait=new WebDriverWait(driver,10);
		TripPlannerPage TP= new TripPlannerPage(driver);
		
		TP.getFromfield().sendKeys(From);
		TP.getTofield().sendKeys(To);
		TP.getLeavinglink().click();
		if (Time.equalsIgnoreCase("Leaving Now")){
			log.info("Reached Leaving Now Testcase");
						
		}
		else if(Time.equalsIgnoreCase("Leaving After")){
			log.info("Reached Arriving After Testcase");
			String ST=fl.TimeWithoutDate(); 
			String date[]=ST.split(":");
			
			TP.getLeavinglink().click();
			TP.getLeavingTab().click();
			TP.timeHours().sendKeys(date[0]);
			TP.timeMins().sendKeys(date[1]);
			
		}
	  else if(Time.equalsIgnoreCase("Arriving Before")){		
		 
		 	log.info("Reached Arriving before Testcase");
			String ST=fl.TimeWithoutDate(); 
			String date[]=ST.split(":");			
			
			wait.until(ExpectedConditions.visibilityOf(TP.getLeavinglink())).click();
			//TP.getArrivingTab().click();
			wait.until(ExpectedConditions.visibilityOf(TP.getArrivingTab())).click();
			Select S= new Select(TP.selectDay());
			S.selectByIndex(1);
			TP.timeHours().sendKeys(date[0]);
			TP.timeMins().sendKeys(date[1]);
		
		}
		
		TP.getGo().click();
		wait.until(ExpectedConditions.visibilityOfAllElements(TP.resultDisplay()));
		log.info("Validating search results");
	    
		if (TP.resultDisplay().size()>0){
			int noofresults=TP.resultDisplay().size();
			log.info(noofresults +" results are found");
		}
		else {
		log.info("no search results found please refine your search");
			
		}
		driver.close();
	
		/*log.info("Entered in to "+Time+" TestCase");
		fl.validateSearchResults();
		log.info("Validated"+Time+" TestCase");
		driver.close();*/
	}
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[3][3];
		
		data[0][0]="North Sydney Station, North Sydney";
		data[0][1]="Town Hall Station, Sydney";
		data[0][2]="Leaving Now";
		data[1][0]="North Sydney Station, North Sydney";
		data[1][1]="Town Hall Station, Sydney";
		data[1][2]="Leaving After";
		data[2][0]="North Sydney Station, North Sydney";
		data[2][1]="Town Hall Station, Sydney";
		data[2][2]="Arriving Before";
		
		
		return data;
	}
	
	/*@AfterTest
	public void validateSearchResults(){
		log.info("Validating search results");
	    
		if (TP.resultDisplay().size()>0){
			int noofresults=TP.resultDisplay().size();
			log.info(noofresults +" results are found");
		}
		else {
		log.info("no search results found please refine your search");
			
		}
		driver.close();
	}*/
		

}
