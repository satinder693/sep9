package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC003_webTables {
	public static WebDriver driver;
	public static void main(String[] args) {
		Base_Util bu = new Base_Util();
		driver = bu.openBrowser("Edge");
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> tableInfo = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
		boolean status = true;
		int noOfVal = tableInfo.size();
		for(int i=0; i<noOfVal; i++) {
			String values = tableInfo.get(i).getText();
			if(values.equalsIgnoreCase("Austria")) {
				status = true;
				break;
			}else {
				status = false;
			}
			
		}
		if(status==true) {
			System.out.println("Expected value is  present in the table");
		}else {
			System.out.println("Expected value  not present in the table");
		}
	}

}
