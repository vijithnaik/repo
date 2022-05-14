package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	WebElement Emailid;

	public WebElement Emailid() {

		return Emailid;

	}

	@FindBy(id="input-password")
	WebElement password;

	public WebElement password() {
		return password;
		}
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement login;
		public WebElement login() {

			return login;
		
		
		
	}

}
