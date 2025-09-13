package pages;

//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.hc.core5.util.Asserts;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	WebDriver driver;
	
	public homePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By header=By.xpath("//h1[.='Practice Page']");
	private By name=By.id("name");
	private By alert=By.id("alertbtn");
	
	
	public void verifyUserOnRightPage() {
	        WebElement val = driver.findElement(header);
	        //assertEquals("Practice Page", val.getText());
	}
	public void ownName(String na) {
		WebElement val=driver.findElement(name);
		val.sendKeys(na);
	}
	
	public void alert() {
		WebElement val=driver.findElement(alert);
		val.click();
	}
	public void alertAction() {
		Alert al=driver.switchTo().alert();
		al.accept();
		
	}

}
