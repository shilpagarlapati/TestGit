package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripPlannerPage {
	
	public WebDriver driver;
	
	By Fromfield=By.cssSelector("#search-input-From");
	By Tofield=By.cssSelector("#search-input-To");
	By leavingnow=By.xpath("//*[@id='tp-search-form']/div[1]/span/a/span[1]");
	By Nowlink=By.xpath("//span[contains(text(),'Now')]");
	By DayList=By.xpath("//select[@id='search-select-date']");
	By TimeHours=By.xpath("//select[@id='search-select-hour']");
	By TimeMins=By.xpath("//select[@id='search-select-minute']");
	By GoBtn=By.cssSelector("#search-button");
	public TripPlannerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement getFromfield() {
		// TODO Auto-generated method stub
		return driver.findElement(Fromfield);
	}	
	public WebElement getTofield() {
		// TODO Auto-generated method stub
		return driver.findElement(Tofield);
		
	}	
	public WebElement getLeavinglink() {
		// TODO Auto-generated method stub
		return driver.findElement(leavingnow);
		
	}
	public WebElement getNowlink() {
		// TODO Auto-generated method stub
		return driver.findElement(Nowlink);
		
	}
	public WebElement selectDay() {
		// TODO Auto-generated method stub
		return driver.findElement(DayList);
		
	}
	public WebElement timeHours() {
		// TODO Auto-generated method stub
		return driver.findElement(TimeHours);
		
	}
	public WebElement timeMins() {
		// TODO Auto-generated method stub
		return driver.findElement(TimeMins);
		
	}
	public WebElement getGo() {
		// TODO Auto-generated method stub
		return driver.findElement(GoBtn);
		
	}

}
