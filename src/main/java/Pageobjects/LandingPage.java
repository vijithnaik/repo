package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	// Page object and page factory
	public LandingPage(WebDriver driver) { // constructor//creating opjects in the class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[@title='My Account']"))
	WebElement accountdropdown;
	 
	@FindBy(linkText="Login")
	WebElement LoginButton;
	
	public WebElement accountdropdown() {
		return accountdropdown;
	}

	public WebElement LoginButton() {
		
		return LoginButton;
	}
}