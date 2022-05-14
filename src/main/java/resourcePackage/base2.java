package resourcePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base2 {

	WebDriver driver;
	public Properties property;
	
	
	@SuppressWarnings("deprecation")
	public WebDriver intializebrowser() throws IOException {
		
		 property = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resourcePackage\\data.properties";
		FileInputStream fis=new FileInputStream(path);
		property.load(fis);
		String browser=property.getProperty("Browser");
		
		if (browser.equalsIgnoreCase("Chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
		
			WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
		
	}
		else if(browser.equalsIgnoreCase("edgebrowser")){
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	
	}
	
	
	
}
	
