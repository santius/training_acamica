package com.automation.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	
	private WebDriver driver;
	
	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/santiago.hernandez/Documents/chromedriver");
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
