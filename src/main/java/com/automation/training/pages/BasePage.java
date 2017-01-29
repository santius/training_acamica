package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}
}
