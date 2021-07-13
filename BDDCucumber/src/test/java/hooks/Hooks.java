package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import utilities.DriverInstance;

public class Hooks extends DriverInstance {

	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Scenario Name: "+scenario.getName());
		System.out.println("Scenario Status: "+scenario.getStatus());
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver =  new ChromeDriver();
		driver.get("https://dev75984.service-now.com/login");
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES); 	
		scenario.embed(screenshotAs, "image/png");
		
	}
	@After
	public void afterScenario(Scenario scenario) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES); 	
		scenario.embed(screenshotAs, "image/png");
		driver.quit();
		System.out.println("Scenario Status: "+scenario.getStatus());
	}
	@BeforeStep
	public void beforeEachStep(Scenario scenario ) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES); 	
		scenario.embed(screenshotAs, "image/png");
	}
	@AfterStep
	public void afterEachStep(Scenario scenario ) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES); 	
		scenario.embed(screenshotAs, "image/png");
	}
}
