package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	private WebElement signinBtn;
	
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
}
