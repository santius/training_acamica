package com.automation.training.pageobject;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.automation.training.appium.AppiumConfig;
import com.automation.training.logging.Logging;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BasePage<T extends AppiumDriver> implements Logging{

	private final T driver;
	private AppiumConfig config = ConfigFactory.create(AppiumConfig.class);

	public BasePage(AppiumDriver<?> pDriver) {
		this.driver = (T) pDriver;
		initElements();
	}

	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	protected T getDriver() {
		return (T) driver;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
		return new FluentWait<>(object).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withTimeout(timeOutSeconds, SECONDS)
				.pollingEvery(1, SECONDS);
	}

	protected FluentWait<T> getWait() {
		return waitOn(getDriver(), config.timeout());
	}

	protected void click(MobileElement element) {
		getWait().until(elementToBeClickable(element)).click();
	}

	protected void click(String text) {
		By locator = AndroidUIAutomator("text(\""+text+"\")");		
		getWait().until(elementToBeClickable(locator)).click();
	}

	protected String getText(MobileElement element) {
		return getWait().until(visibilityOf(element)).getText();
	}
	
	protected void type(MobileElement element, String text) {
		getWait().until(elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}
	
	protected void hideKeyboard(){
		getDriver().hideKeyboard();
	}
}
