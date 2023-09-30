package com.application.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.application.steps.LoginPageSteps;
import com.application.steps.RegistrationPageSteps;
import com.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationTest{	
	
	public LoginPageSteps loginPage = null;
	public RegistrationPageSteps regPage = null;
	
	@Given("Initialize all pages")
	public void initialize_all_pages() {
		WebDriver driver = new BasePage().getDriver();
		loginPage= new LoginPageSteps(driver);
		regPage=new RegistrationPageSteps(driver);	    
	}

	@Given("Launch the application using {string}")
	public void launch_the_application_using(String string) {
		loginPage.getApp(string);
	    
	}

	@Then("Application should be launched with the title {string}")
	public void application_should_be_launched_with_the_title(String string) {
		loginPage.verifyTitle(string);
	    
	}

	@Then("Verify application logo is displayed")
	public void verify_application_logo_is_displayed() {
		loginPage.verifyLogo();
	    
	}

	@Then("Verify application caption is displayed as {string}")
	public void verify_application_caption_is_displayed_as(String string) {
		loginPage.verifyCaption(string);
	    
	}

	@Then("Verify application login page header is displayed as {string}")
	public void verify_application_login_page_header_is_displayed_as(String string) {
		loginPage.verifyLoginHeader(string);
	    
	}

	@When("^User eneter (.*) and (.*)$")
	public void user_eneter_admin_and_admin123(String user,String pass) {
		loginPage.enterCredentials(user, pass);
	    
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		loginPage.clickOnLogInButton();
	    
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
		loginPage.verifyLoginIsSuccessful();	    
	}

}
