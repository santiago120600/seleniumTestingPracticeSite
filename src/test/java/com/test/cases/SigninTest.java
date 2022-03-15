package com.test.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.BaseTest;

public class SigninTest extends BaseTest{
	
	private Object[][] users = {
			{"lokoooo@test.com","Santiago","arvizu","password","Jersey City",30,"4426244708","76220","Melchor ocampo"}
		};
	
	@DataProvider(name="users")
	public Object[][] usersDataProvider() {
		return users; 
	}

	@Test(dataProvider = "users")
	public void signIn(String email, String first_name, String last_name, String password,String city,int state, String phone, String zip, String address) {
		AuthenticationPage authenticationPage = new AuthenticationPage(driver,email);
		authenticationPage.goToRegister();
		SignInPage signInPage = new SignInPage(driver,first_name,last_name,password,city,state,phone,zip,address);
		signInPage.register();
		SignOutPage signOutPage = new SignOutPage(driver);
		signOutPage.validateSections();
	}
}
