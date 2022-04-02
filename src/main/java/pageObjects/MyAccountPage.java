package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyAccountPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@title='Orders']")
	private WebElement orderHistoryAndDetailsSection;

	@FindBy(xpath = "//a[@title='Credit slips']")
	private WebElement myCreditSlipsSection;

	@FindBy(xpath = "//a[@title='Addresses']")
	private WebElement myAddressesSection;

	@FindBy(xpath = "//a[@title='Information']")
	private WebElement myPersonalInformationSection;

	@FindBy(xpath = "//a[@title='My wishlists']")
	private WebElement myWhishListsSection;

	@FindBy(xpath = "//a[@class='logout']")
	private WebElement signOutBtn;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@Test
	public void validateSections() {
		this.wait.until(ExpectedConditions.visibilityOf(this.orderHistoryAndDetailsSection));
		this.wait.until(ExpectedConditions.visibilityOf(this.myCreditSlipsSection));
		this.wait.until(ExpectedConditions.visibilityOf(this.myAddressesSection));
		this.wait.until(ExpectedConditions.visibilityOf(this.myPersonalInformationSection));
		this.wait.until(ExpectedConditions.visibilityOf(this.myWhishListsSection));
		this.signOutBtn.click();
	}
}
