package sp.com.module;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import package1.SendAttachmentInEmail;
import sp.com.locators.Loginpagelocators;

public class ResetdataExcel extends SendAttachmentInEmail implements Loginpagelocators{
	private static XSSFSheet Sheet1;


	private static XSSFRow Row;
	public static final String Path_TestData = "C:\\Users\\yugandhar\\workspace\\SeleniumPractice\\src\\testdata\\";
	public static final String File_TestData = "TestData.xlsx";


	private static XSSFWorkbook workbook;
	static WebDriver driver=null;

	/*	public static void highlightElement(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 10px solid red;");
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		//		driver.manage().timeouts().Explicitwait(100, TimeUnit.SECONDS);
	}
	 */
	
	@Test
	@Parameters({"aPPURL","sUsername","sPassword","fIlepath"})
	public void resetdata(String aPPURL,String sUsername, String sPassword,String fIlepath) throws Exception {

		//WebDriver driver = new FirefoxDriver();
		workbook = new XSSFWorkbook();
		Logger log=Logger.getLogger("ResetdataExcel");
		Sheet1=workbook.createSheet("ProblemTypesData");
		ResetdataExcel obj = new ResetdataExcel();

		String chrome="E:\\Selenium Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		driver = new ChromeDriver();
		//Login into application
		driver.get(aPPURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Resetfunctionality.highlightElement(driver.findElement(By.id("inputEmail")));
		driver.findElement(USERNAME).sendKeys(sUsername);
		driver.findElement(PASSWORD).sendKeys(sPassword);
		driver.findElement(LOGINBUTTON).click();
		log.info("User clicked on the login button");

		//verification of loading bars
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String value1 =driver.findElement(By.className("loader")).getText();
		if(value1!=null)
			System.out.println("Loading Bar is available");
		else{System.out.println("Loading bar not available");}
		log.info("loading bar is available");

		//verification of dash character
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String value2 =driver.findElement(By.className("spine-canvas")).getText();
		if(value2!=null)
			System.out.println("Dash is available");
		else{System.out.println("Dash is not available");}
		
		log.info("dash is available");

		/*	//verification of World selector
		String value3 =driver.findElement(By.className("vsl_velocity_views_student_dashboard-worlds-label")).getText();
		if(value3!=null)
			System.out.println("World selecor is available");
		else{System.out.println("World selector not available");}*/
		driver.get("https://velocity.voyagersopris.com/scene");

		Select LessontypeDP=new Select(driver.findElement(By.id("lessonType")));
		List<WebElement> ProblemTypes = LessontypeDP.getOptions();
		System.out.println(ProblemTypes.size());
		int x=0;
		int j;
		for(int i=0;i<3;i++)
		{
			LessontypeDP.selectByIndex(i);
			Row = Sheet1.createRow(x);
			Cell Cell1=Row.createCell(0);
			Cell1.setCellValue(ProblemTypes.get(i).getText());
			System.out.println(ProblemTypes.get(i).getText());
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Select LessonDP=new Select(driver.findElement(By.id("lesson")));
			List<WebElement> Lessonnames=LessonDP.getOptions();
			for(j=0;j<Lessonnames.size();j++)	
			{
				if(x==x+j)
				{
					Cell Cell2=Row.createCell(1);
					Cell2.setCellValue(Lessonnames.get(j).getText());
					x++;
				}
				else
				{
					//System.out.println(Lessonnames.get(j).getText());
					Row = Sheet1.createRow(x);
					Cell Cell2=Row.createCell(1);
					Cell2.setCellValue(Lessonnames.get(j).getText());
					x++;
				}
			}
log.info("Problem type"+" "+i+" "+"is printed");
		}
		FileOutputStream out= new FileOutputStream(fIlepath);
		workbook.write(out);
		out.close();
		System.out.println("Succsess");
		obj.sendemail(fIlepath);
	}

}
