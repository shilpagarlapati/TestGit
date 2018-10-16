package TripPlanner.TripPlannerNSW;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.base;
import objectrepository.TripPlannerPage;

class TripPlannerCaseNow extends base {
	
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String From, String To) throws IOException{
		driver=initializeDriver();
		log.info("driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		
		TripPlannerPage TP= new TripPlannerPage(driver);
		
		TP.getFromfield().sendKeys(From);
		TP.getTofield().sendKeys(To);
		TP.getLeavinglink().click();
		TP.getGo().click();
	}
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[1][2];
		
		data[0][0]="North Sydney Station, North Sydney";
		data[0][1]="Town Hall Station, Sydney";
		
		
		
		return data;
	}
	@Test
	public void validateSearchResults(){
		log.info("Validating search results");
		List<WebElement> st= driver.findElements(By.xpath("//*[contains(@id,'tripAnchor')]"));
		if (st.size()>0){
			int noofresults=st.size();
			log.info(noofresults +" results are found");
		}
		else {
		log.info("no search results found please refine your search");
			
		}
		
	}

}
