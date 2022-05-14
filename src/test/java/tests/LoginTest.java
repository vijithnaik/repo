package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import Pageobjects.LoginPage;
import Pageobjects.Myaccount;
import resourcePackage.base2;

public class LoginTest extends base2 {
	WebDriver driver;
// logintest is a child class of base2

	@Test(dataProvider="getlogindata")//4. connected getlogindata with test provider
	public void login(String email,String password,String expectedresult) throws IOException {

		driver = intializebrowser();// base2 method will return driver
		driver.get(property.getProperty("url"));
// create a object from landing page
// call the class---methods
		LandingPage landingpage = new LandingPage(driver);
		landingpage.accountdropdown().click();
		landingpage.LoginButton().click();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.Emailid().sendKeys(email);//will take directly from the parameters 
		loginpage.password().sendKeys(password);//
		loginpage.login().click();

		Myaccount myaccount = new Myaccount(driver);
	String actualresult = null;
	try {
			if(myaccount.Editaccount().isDisplayed()){
				actualresult="sucessfull";}}
			catch(Exception e) {
					actualresult="failed";}
				Assert.assertEquals(actualresult, expectedresult);
				}
	@AfterMethod
	public void close() {
		driver.close();
	}
@DataProvider//4. for creating the data
public Object[][] getlogindata(){
	Object[][] data= {{"vijithnaik5@gmail.com","password123","sucessfull"},{"dummy@gmail.com","dummy","failed"}};
	return  data;
}
}


