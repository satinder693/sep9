package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Common_Util {
	public void closeApplication(WebDriver driver) {
		driver.close();
		System.out.println("Application closed successfully");
	}
	public void quitAll(WebDriver driver) {
		driver.quit();
		System.out.println("All the application windows closed successfully");
	}
	public void verifyTitle(WebDriver driver, String expTitle) {
		String actTitle = driver.getTitle();
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Actual title matches the expected title");
		}else {
			System.out.println("Actual title does not match the expected title");
		}
	
	}
	public void checkCorrectApplicationOpened(WebDriver driver, String valInUrl) {
		String appUrl = driver.getCurrentUrl();
		if(appUrl.indexOf(valInUrl)>=0) {
			System.out.println("Correct application is opened");
		}else {
			System.out.println("Wrong applicatio is  opened");
		}
	}
	public void enterValueInFieldAndVerify(WebElement ele, String valToEnter, String eleName) {
		boolean status = ele.isDisplayed();
		try {
			if(status==true) {
		}
			ele.clear();
			ele.sendKeys(valToEnter);
			String valEntered = ele.getAttribute("value");
			if(valEntered.isEmpty()) {
				System.out.println(eleName+" field is empty");
			}else {
				System.out.println(eleName+" field is not empty");
			}
			System.out.println("Value entered in the "+eleName+" field is "+valEntered);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void verifyLink(WebDriver driver, String expLink) {
		boolean status = true;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int noOfLinks =links.size();
		for(int i=0; i<noOfLinks; i++) {
			String linkNames = links.get(i).getText();
			if(linkNames.equalsIgnoreCase(expLink)) {
				status = true;
				break;
			}else {
				status = false;
			}
		}
		if(status == true ) {
			System.out.println("Expected link is present");
		}else {
			System.out.println("Expected link is not present");
		}
	}
	public void verifyValueInDropDown(WebElement ele, String expVal) {
		boolean status = true;
		Select select = new Select(ele);
		select.selectByVisibleText(expVal);
		List<WebElement> ddValues = select.getOptions();
		int noOfValues = ddValues.size();
		for(int i=0; i<noOfValues; i++) {
			String ddValNames = ddValues.get(i).getText();
			if(ddValNames.equalsIgnoreCase(expVal)) {
				status = true;
				break;
			}else {
				status = false;
			}
		}
		if(status==true) {
			System.out.println(expVal+" - is present in the dropdown");
		}else {
			System.out.println(expVal+" - is not present in the dropdown");
		}
	}
}
