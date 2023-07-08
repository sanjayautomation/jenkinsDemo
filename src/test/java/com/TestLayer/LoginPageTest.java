package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClass;
import com.PageLayer.LoginPage;

@Test(groups= {"LoginPage","Regression"})
public class LoginPageTest extends BaseClass {
	private LoginPage login;
	@BeforeTest
	public void setup() {
		BaseClass.initialization();
	}
	@Test(priority = 1)
	public void validateLoginFunctionality() {
		login=new LoginPage();
		login.typeUsername(prop.getProperty("username"));
		login.typePassword(prop.getProperty("password"));
		login.clickOnLoginButton();
		
	}
	@Test (priority = 2)
	public void validateTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(true, driver.getTitle().contains("CRM"));
	}
	
	@Test (priority = 3)
	public void validateUrl() throws InterruptedException {
	
		Assert.assertEquals(true, driver.getCurrentUrl().contains("cogmento"));
	}
	@Test (priority =4)
	public void abc() {
		Assert.assertEquals(true, true);
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
