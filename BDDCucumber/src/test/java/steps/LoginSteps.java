package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverInstance;

public class LoginSteps extends DriverInstance {

	//ChromeDriver driver;
/*	public LoginSteps() {
		PageFactory.initElements(driver, this);
		}	
		@CacheLookup
		@FindBy(xpath="//input[@name='user_name']") 
		private WebElement userName;
		@CacheLookup
		@FindBy(xpath="//input[@name='user_password']") 
		private WebElement password;
		@CacheLookup
		@FindBy(xpath="//button[@id='sysverb_login']") 
		private WebElement loginButton;
		@CacheLookup
		@FindBy(xpath="//div[text()='Power your workflow applications']")
		private WebElement text;*/
/*	
	@Given("Launch the browser")
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Given("URL is loaded")
	public void loadURL() {
		driver.get("https://dev75984.service-now.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	*/
	@When("User enters the username as {string}")
	public void enterUserName(String userName) {
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		//this.userName.sendKeys(userName);
	}
	@When("User enters the password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		//this.password.sendKeys(password);
	}	
	@When("User clicks the signin button")
	public void clickSignIn() {
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//loginButton.click();
	}
	@Then("User should see the dashboard Page")
	public void verifySucessfullSignIn() {
		driver.switchTo().frame("gsft_main");
		WebElement text= driver.findElement(By.xpath("//div[text()='Power your workflow applications']"));
		if(text.isDisplayed()) {
			driver.switchTo().defaultContent();
			System.out.println("TC Passed");
		}
		else {
			System.err.println("TC Failed");
		}
		//driver.quit();
	}
	@Then("User should not see the dashboard Page")
	public void verifyUnSucessfullSignIn() {
		WebElement text= driver.findElement(By.xpath("//span[@class='dp-invalid-login-msg']"));
		if((text.isDisplayed())) {
			System.out.println("TC Passed");
		}
		else {
			System.err.println("TC Failed");
		}
		//driver.quit();
	}
	@Then("Validate login")
	public void validateLogin() {
		try {
			boolean textDisplayed = driver.findElement(By.xpath("//span[@class='dp-invalid-login-msg']")).isDisplayed();
			if(textDisplayed) {
				System.err.println("Login is unsuccessfull");
				//driver.quit();
			}
		}
		catch(Exception ex) {
			driver.switchTo().frame("gsft_main");
			WebElement text= driver.findElement(By.xpath("//div[text()='Power your workflow applications']"));
			if(text.isDisplayed()) {
				driver.switchTo().defaultContent();
				System.out.println("Login is successfull");
			}
			else {
				System.err.println("Login is successfull but unknown error");
			}
		
			//driver.quit();
		}
	}
}
