package com.automation.training.pages;

import org.openqa.selenium.By;

import com.automation.training.appium.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class WikiHomePage extends BasePage<AndroidDriver<AndroidElement>> {

  NavigationWidget navigationWidget;
  MenuWidget menuWidget;

  public WikiHomePage(AppiumDriver<?> driver) {
    super(driver);
  }

  public NavigationWidget navigation() {
    return navigationWidget;
  }
  
  public MenuWidget menu() {
    return menuWidget;
  }

  public void la() {
    getDriver().findElement(By.id("org.wikipedia:id/menu_overflow_button")).click();
    
  }
  
}
