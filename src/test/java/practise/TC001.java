package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC001 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Base_Util bu = new Base_Util();
		driver = bu.openBrowser("Edge");
		driver.get("https://www.facebook.com");
		System.out.println("Title of the opened application is "+driver.getTitle());
		System.out.println("Url of the opened application is "+driver.getCurrentUrl());
		System.out.println("Index of facebook in the url is "+driver.getCurrentUrl().indexOf("facebook"));
		if(driver.getCurrentUrl().contains("facebook")) {
			System.out.println("Facebook is contained in the url");
		}else {
			System.out.println("Facebook is not contained in the url");
		}
		System.out.println(driver.findElement(By.linkText("Forgot password?")).getText());
		Common_Util cu = new Common_Util();
		cu.verifyTitle(driver, "Facebook - log in or sign up");
		cu.checkCorrectApplicationOpened(driver, "facebook");
		cu.enterValueInFieldAndVerify(driver.findElement(By.name("email")), "sattoz", "login email");
		cu.verifyLink(driver, "Create Page");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(5000);
		cu.verifyValueInDropDown(driver.findElement(By.id("month")), "Jan");
		
		driver.findElement(By.linkText("Forgot password?"));
		
	}

}
