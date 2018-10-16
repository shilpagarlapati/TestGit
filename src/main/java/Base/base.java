package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException{
		String projdir=System.getProperty("user.dir");
		String file= projdir+"\\src\\main\\java\\resources\\data.properties";
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(file);
		
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")){
			
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",prop.getProperty("iepath") );
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

}
