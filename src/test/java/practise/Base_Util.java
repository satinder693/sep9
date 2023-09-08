package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Util {
	public static WebDriver driver;
	public WebDriver openBrowser(String bName) {
		if(bName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			if(bName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}else {
				System.out.println("Browser can be either Crome or Edge");
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
	
}
