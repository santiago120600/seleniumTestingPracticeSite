package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AuthenticationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private String email;

	@FindBy(id="email_create")
	private WebElement emailInput;

	@FindBy(id="SubmitCreate")
	private WebElement createAccountBtn;
	
	public AuthenticationPage(WebDriver driver, String email) {
		super();
		this.driver = driver;
		this.email = email;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}

	@Test
	public void fillCreateAccountCard() {
		this.wait.until(ExpectedConditions.visibilityOf(this.emailInput));
		this.emailInput.sendKeys(this.email);
		this.createAccountBtn.click();
		assertEquals(this.emailInput.getCssValue("color"), "rgba(53, 179, 63, 1)");
	}

}
