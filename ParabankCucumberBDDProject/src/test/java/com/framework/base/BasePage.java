package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.framework.utilities.ReadProp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {

	// will have common methods to launch the browser and close browser
	private static WebDriver driver = null;

	// method to launch browser
	@Before
	public void setupBrowser() {
		Properties prop = ReadProp.readData(System.getProperty("user.dir") + "\\Config\\Config.properties");
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@After(order=1)
	public void failedTestListner(Scenario scenario) {
		if(scenario.isFailed()) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				byte [] fileContent = FileUtils.readFileToByteArray(file);
				scenario.attach(fileContent, "image/png", "Step is Failed, Refer Screenshot");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// method to close browser
	@After(order=0)
	public void tearDownBrowser() {
		driver.quit();
	}

	// method to share driver
	public WebDriver getDriver() {
		return driver;
	}

}
