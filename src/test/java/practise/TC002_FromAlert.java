package practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TC002_FromAlert {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Base_Util bu = new Base_Util();
		driver = bu.openBrowser("Edge");
		driver.get("https://www.rediff.com");
		driver.findElement(By.xpath("//a[@title='Already a user? Sign in']")).click();
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("Message in the alert is -  "+alertMsg);
		
		if(alertMsg.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("Message in the alert is the same as expected");
		}else {
			System.out.println("Message in the alert is not the same as expected");
		}
		alert.accept();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Privacy Policy")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String firstWindowId = itr.next();
		String secondwindowId = itr.next();
		driver.switchTo().window(secondwindowId);
		System.out.println("Title of the second window is "+driver.getTitle());
	}

}
