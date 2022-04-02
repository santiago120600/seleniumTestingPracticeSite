package com.test.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.BaseTest;

import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage;
import pageObjects.LandingPage;
import pageObjects.MyAccountPage;

public class SigninTest extends BaseTest{
	
	private Object[][] users = {
			{"lokooooooo@test.com","Santiago","arvizu","password","Jersey City",30,"4426244708","76220","Melchor ocampo"}
		};
	
	@DataProvider(name="users")
	public Object[][] usersDataProvider() {
		return users; 
	}

	@Test(dataProvider = "users")
	public void signIn(String email, String first_name, String last_name, String password,String city,int state, String phone, String zip, String address) {
		driver.get("http://automationpractice.com/index.php");
		LandingPage landinPage = new LandingPage(driver);
		landinPage.getSigninBtn().click();
		
		AuthenticationPage authenticationPage = new AuthenticationPage(driver,email);
		authenticationPage.fillCreateAccountCard();
		CreateAccountPage createAccountPage = new CreateAccountPage(driver,first_name,last_name,password,city,state,phone,zip,address);
		createAccountPage.register();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.validateSections();
	}
}
