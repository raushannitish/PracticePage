package hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.Duration;

public class hook {
    public static WebDriver driver;
	private configReader config; 

    @Before
    public void setUp() {
    	config = new configReader(); 
        String browser = config.getProperty("browser"); 
        String url = config.getProperty("url"); 
 
        if(browser.equalsIgnoreCase("chrome")) { 
            WebDriverManager.chromedriver().setup(); 
            driver = new ChromeDriver(); 
        } 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
    	
		if(scenario.isFailed()) {
    		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            System.out.println("📸 Screenshot captured for failed scenario: " + scenario.getName());
    	}
        System.out.println("🧹 Closing browser after scenario...");
        if (driver != null) {
            driver.quit();
        }
    }
}

