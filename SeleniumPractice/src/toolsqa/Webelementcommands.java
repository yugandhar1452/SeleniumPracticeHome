package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelementcommands {

	
		public  static WebDriver driver;
		
		
		public static void main(String[] args) {
		String chrome="E:\\Selenium Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		

		//open required webpage
		driver.get("https://gmail.com");		

		//find webelement
		WebElement element=driver.findElement(By.id("Email"));
		System.out.println(element);
	}

}
