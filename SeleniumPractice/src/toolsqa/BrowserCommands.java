package toolsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public  static WebDriver driver;
	
	
	public static void main(String[] args) {
	String chrome="E:\\Selenium Practice\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chrome);
	driver = new ChromeDriver();
	
	//open required webpage
	driver.get("https://gmail.com");
	
	//get URL  of current page
	String currentURL=driver.getCurrentUrl();
	System.out.println(currentURL);
	
	//get page source of current web page
	String pagesource=driver.getPageSource();
	System.out.println(pagesource);
int a=pagesource.length();
System.out.println("\n"+"\n"+a);
		}

}
