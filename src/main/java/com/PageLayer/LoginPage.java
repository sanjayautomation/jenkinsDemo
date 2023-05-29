package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.BaseClass;
import com.utilsLayer.UtilsClass;

public class LoginPage extends BaseClass {
	
	//POM with page factory
	@FindBy(name="email")
	private WebElement uname;
	
	@FindBy (name="password")
	private WebElement pass;
	
	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Associated methods for each and every object
	
	public void typeUsername(String username) {
		UtilsClass.enterValue(uname, username);
	}
	
	public void typePassword(String password) {
		UtilsClass.enterValue(pass, password);
	}
	
	public void clickOnLoginButton() {
		UtilsClass.clickOnElement(loginButton);
	}

}
