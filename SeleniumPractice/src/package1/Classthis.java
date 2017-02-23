package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Classthis {


	private WebDriver yug = new ChromeDriver();

	@Test
	public static void method2()
	{
		String chrome="E:\\Selenium Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chrome);
		
		
		
	}

	@Test
	public void method1() {
		yug.get("https://www.gmail.com");
		System.out.println("This is print :: "+yug);
		yug.close();
	}
	@Test
	public void reverseString(){
		String r = "rabr";
		String s="";
		int j=r.length()-1;
		for(int i=0;i<r.length();i++){
			String a=(r.charAt(i))+"";
			String b= r.charAt(j)+"";
			if(a.equals(b)){
				j--;
				s=s+a;
			}else{
				System.out.println("not polynidr");
				break;
			}
		}
		if(s.equals(r)){
			System.out.println("polynidr");
		}
	}

}
