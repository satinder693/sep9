package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TC003_Frames {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Base_Util bu = new Base_Util();
		driver = bu.openBrowser("Edge");
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		String dragText = driver.findElement(By.id("draggable")).getText();
		System.out.println("Text in the draggable is "+dragText);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		System.out.println("Draggable dropped on droppable");
		//Thread.sleep(5000);
		driver.switchTo().defaultContent();
		action.moveToElement(driver.findElement(By.linkText("Plugins"))).build().perform();
		action.click(driver.findElement(By.linkText("Plugins"))).build().perform();
		action.contextClick(driver.findElement(By.linkText("Events"))).build().perform();
		
		
		
	}

}
