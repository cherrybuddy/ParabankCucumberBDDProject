package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getApp(String url) {
		launchApplication(url);
	}
	
	public void verifyTitle(String expTitle) {
		Assert.assertEquals(getTitle(), expTitle);
	}
	
	public void verifyLogo() {
		Assert.assertTrue(isElementDisplayed(logo));
	}
	
	public void verifyCaption(String expCap) {
		Assert.assertEquals(getElementText(caption), expCap);
	}
	
	public void verifyLoginHeader(String expHeader) {
		Assert.assertEquals(getElementText(loginPageHeader), expHeader);
	}
	
	public void enterCredentials(String username,String password) {
		enterInfo(usernameTxtb, username);
		enterInfo(passwordTxtb, password);
	}
	
	public void clickOnLogInButton() {
		click(loginBtn);
	}

	public void verifyLoginIsSuccessful() {
		waitForElement(accountOverviewPageHeader, 10);
	}
	
	public void clickOnRegistrationLink() {
		click(registrationLink);
	}

}
