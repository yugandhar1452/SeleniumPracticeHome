package SeleniumVelocity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

public class VelocityLogin {
  
	 WebDriver driver;
	
	
	 @DataProvider(name="logindetials")
	 public static Object[][] credentials()
	 {
		 return new Object[][]{{"5gradejan16a", "5gradejan16a"},{"1gradejan16a", "1gradejan16a"}};
	 }
	 
	 
	 
	
	@Test(dataProvider="logindetails")
	//@Parameters({"uSername", "pAssword"})
  public void loginpage(String uSername, String pAssword) {
		
		driver.findElement(By.id("inputEmail")).sendKeys(uSername);
		driver.findElement(By.id("inputPassword")).sendKeys(pAssword);
		driver.findElement(By.xpath("//form[@id='k5i-login-form']/input[3]")).click();
		
	}
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  String chrome="E:\\Selenium Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		//Login into application
		driver.get("https://velocity.voyagersopris.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }

}
