package com.automation.training.appium;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.AppiumDriver;

@SuppressWarnings("rawtypes")
public abstract class BasePage<T extends AppiumDriver> {

  private final T driver;
  private static final int TIME_OUT_IN_SECONDS = 60;

  @SuppressWarnings("unchecked")
  public BasePage(AppiumDriver<?> pDriver) {
    this.driver = (T) pDriver;
    PageFactory.initElements(pDriver, this);
  }

  protected T getDriver() {
    return driver;
  }

  public void dispose() {
    if (driver != null) {
      driver.quit();
    }
  }

  protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
    return new FluentWait<>(object).ignoring(NoSuchElementException.class)
                                   .ignoring(StaleElementReferenceException.class)
                                   .withTimeout(timeOutSeconds, SECONDS)
                                   .pollingEvery(1, SECONDS);
  }

  protected FluentWait<T> getWait() {
    return waitOn(getDriver(), TIME_OUT_IN_SECONDS);
  }

  protected void click(WebElement element) {
    getWait().until(elementToBeClickable(element)).click();
  }

  protected void type(WebElement element, String text) {
    getWait().until(elementToBeClickable(element));
    element.clear();
    element.sendKeys(text);
  }

}
