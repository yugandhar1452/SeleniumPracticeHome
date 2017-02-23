package package1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakeScreenshot {

	public static void main(String[] args) throws Exception {
		
		 System.setProperty("webdriver.chrome.driver", "E://Selenium Practice//chromedriver.exe");
	        WebDriver driver = new ChromeDriver(); 
driver.get("https://www.gmail.com");
driver.findElement(By.id("Email")).sendKeys("yugandhar.nalam");
driver.findElement(By.id("next")).click();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("mymother@2");
driver.findElement(By.id("signIn")).click();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.manage().window().maximize();
File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
FileUtils.copyFile(srcFile, new File("E://Selenium Practice//Screenshot-1.jpg"));

driver.close();
	}

}

