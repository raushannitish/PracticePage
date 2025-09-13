
package stepDefinitions;
import org.openqa.selenium.WebDriver;

import hooks.hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;

public class appForm{
	WebDriver driver = hook.driver;
	homePage pg = new homePage(driver);
	
	
	@Given("verify that user is on right page")
	public void rightPage() throws InterruptedException {
		Thread.sleep(5000);
		pg.verifyUserOnRightPage();
		
		
	}
	@Given("The user types own name as {string}")
	public void ownName(String name) {
		pg.ownName(name);
	}
	
	
	@When("The user click on alert button")
	public void alertButton() {
		pg.alert();
	}
	@Then("a pop has been sown")
	public void sownMessage() throws InterruptedException {
		pg.alertAction();
		Thread.sleep(20000);
		
	}

}
