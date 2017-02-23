package sp.com.module;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sp.com.locators.Loginpagelocators;
import utility.Basesetup;
import utility.ExcelUtils;


public class Loginpage implements Loginpagelocators {

	WebDriver driver=null;

	@BeforeMethod
	public void setup()
	{
		Basesetup bp = new Basesetup();
		driver=bp.getdriver();
	}
	@DataProvider(name="test1")
	public static Object[][]credentials ()
	{
		return new Object[][]
				{{"5gradejan16a", "5gradejan16a"},
			{"5gradejan16a","5gradejan16a"}};
	}


	@Test
	@Parameters({"aPPURL","sUsername","sPassword","fIlepath","sHeetname"})
	public void resetdata(String aPPURL,String sUsername, String sPassword,String fIlepath,String sHeetname) throws Exception {

		//WebDriver driver = new FirefoxDriver();
		//Login into application
		final Logger log = Logger.getLogger("devpinoyLogger");
		driver.get(aPPURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username= driver.findElement(USERNAME);
		String value1=ExcelUtils.getCellData(0,0,fIlepath,sHeetname);
		username.sendKeys(value1);
		Assert.assertTrue(username.isDisplayed());
		log.info("Username filed is identified");
		String value2=ExcelUtils.getCellData(0,1,fIlepath,sHeetname);
		driver.findElement(PASSWORD).sendKeys(value2);
		driver.findElement(LOGINBUTTON);
		log.info("password filed is identified");
		driver.close();
	}
}
