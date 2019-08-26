package seleniumgluecode;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FeedbackTest {
	static WebDriver driver;

	public static WebDriver setDriver(String browserType, String appURL) {
		switch (browserType.toUpperCase()) {
		case "CHROME":
			driver = initChromeDriver(appURL);
			break;
		case "FIREFOX":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			driver = initChromeDriver(appURL);
		}
		return driver;
	}
	private static WebDriver initChromeDriver(String appURL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "lib"+ File.separator+"chromedriver.exe");		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "lib" + File.separator + "gecko" + File.separator + "geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);

		return driver;
	}

	@Given("^User is on website \"([^\"]*)\"$")
	public void user_is_on_website(String url) throws Throwable {
		setDriver("firefox", url);
	}

	@When("^User clicks on feedback button$")
	public void user_clicks_on_feedback_button() throws Throwable {
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='usabilla_live_button_container']")).isDisplayed();
		Integer size = driver.findElements(By.tagName("iframe")).size();

		for (int i = 0; i <= size; i++) {
			driver.switchTo().frame(i);
			int total = driver.findElements(By.xpath("/html[1]/body[1]/img[1]")).size();
			if (total == 1) {
				driver.findElement(By.xpath("/html[1]/body[1]/img[1]")).click();
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				break;
			} else {
				driver.switchTo().defaultContent();
			}
		}
		Thread.sleep(2000);
	}

	@And("^User selects Generic Feedback button$")
	public void user_selects_Generic_feedback_button() throws Throwable {
		Thread.sleep(2000);
		Integer frameSize = driver.findElements(By.tagName("iframe")).size();
		if (frameSize > 0) {
			Thread.sleep(2000);
			driver.switchTo().frame(4);
			int total1 = driver.findElements(By.xpath("//*[@id=\"contents\"]/div[3]")).size();
			if (total1 == 1) {
				driver.findElement(By.xpath("/html/body/div/div[3]")).click();
				Thread.sleep(2000);
			}
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
	}

	@When("^What do you think of us smiley selected$")
	public void what_do_you_think_feedback_option_select() throws Throwable {
		Integer frameSize1 = driver.findElements(By.tagName("iframe")).size();
		if (frameSize1 > 0) {
			driver.switchTo().frame(4);
			int totalFrame = driver.findElements(By.xpath("//li[@class='rating_4']//label[contains(text(),'4')]"))
					.size();
			if (totalFrame == 1) {
				driver.findElement(By.xpath("//li[@class='rating_4']//label[contains(text(),'4')]")).click();
				Thread.sleep(2000);
			}

		}
	}

	@And("^User selects \"([^\"]*)\" subject$")
	public void user_selects_subject(String url) throws Throwable {
		driver.findElement(By.name("subject"));
		Select subjectDrop = new Select(driver.findElement(By.name("subject")));
		subjectDrop.selectByValue("compliment");
	}

	@Then("^User should see Submit button$")
	public void user_should_see_submit_button() throws Throwable {
		Assert.assertEquals("Submit button is not visible to user", true,driver.findElement(By.xpath("//button[@class='submit']")).isEnabled());
	}

	@Then("^User should be able to select Specific Feedback button$")
	public void user_selects_Specific_feedback_button() throws Throwable {
		Thread.sleep(2000);
		Integer frameSize = driver.findElements(By.tagName("iframe")).size();
		if (frameSize > 0) {
			Thread.sleep(2000);
			driver.switchTo().frame(4);
			int total1 = driver.findElements(By.xpath("//div[@class='choice choice_specific']")).size();
			if (total1 == 1) {
				driver.findElement(By.xpath("//div[@class='choice choice_specific']")).click();
				Thread.sleep(2000);
			}
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
	}

	@And("^Feedback form details are filled such as \"([^\"]*)\" and \"([^\"]*)\" details$")
	public void feedback_form_details_filled(String toShare, String email) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[2]//div[1]//textarea[1]")).click();
		driver.findElement(By.xpath("//span[2]//div[1]//textarea[1]")).sendKeys(toShare);
		driver.findElement(By.xpath("//span[2]//div[2]//input[1]")).click();
		driver.findElement(By.xpath("//span[2]//div[2]//input[1]")).sendKeys(email);
		driver.findElement(By.xpath("//span[2]//div[3]//fieldset[1]//div[1]//label[9]//input[1]")).click();
		Thread.sleep(2000);
	}

}
