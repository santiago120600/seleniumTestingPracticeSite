package com.test.cases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SignInPage{

	private WebDriver driver;
	private WebDriverWait wait;
	private String first_name;
	private String last_name;
	private String password;
	private String city;
	private int state;
	private String phone;
	private String zip;
	private String address;

	@FindBy(id="customer_firstname")
	private WebElement firstNameInput;
	
	@FindBy(id="customer_lastname")
	private WebElement lastNameInput;

	@FindBy(id="passwd")
	private WebElement passwordInput;
	
	@FindBy(id = "phone_mobile")
	private WebElement phoneInput;
	
	@FindBy(id = "postcode")
	private WebElement zipInput;
	
	@FindBy(id = "address1")
	private WebElement addressInput;

	@FindBy(id = "city")
	private WebElement cityInput;

	@FindBy(id = "id_state")
	private WebElement stateInput;

	@FindBy(id = "submitAccount")
	private WebElement registerBtn;

	public SignInPage(WebDriver driver, String first_name, String last_name, String password, String city, int state, String phone, String zip, String address) {
		super();
		this.driver = driver;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.zip = zip;
		this.address = address;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void register() {
		//fill
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
		this.firstNameInput.sendKeys(first_name);
		this.lastNameInput.sendKeys(last_name);
		this.passwordInput.sendKeys(password);
		this.cityInput.sendKeys(city);
		//check validate
		//check border color green
		assertEquals(this.firstNameInput.getCssValue("color"), "rgba(53, 179, 63, 1)");
		assertEquals(this.lastNameInput.getCssValue("color"), "rgba(53, 179, 63, 1)");
		assertEquals(this.passwordInput.getCssValue("color"), "rgba(53, 179, 63, 1)");
		
		//State
		Select selectState = new Select(stateInput);
		selectState.selectByIndex(this.state);//New Hampshire
		
		this.zipInput.sendKeys(zip);
		this.addressInput.sendKeys(address);
		this.phoneInput.sendKeys(phone);
		registerBtn.click();
	}
	
}
