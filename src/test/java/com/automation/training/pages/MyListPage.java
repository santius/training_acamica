package com.automation.training.pages;

import com.automation.training.appium.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class MyListPage extends BasePage<AndroidDriver<AndroidElement>> {

  NavigationWidget navigationWidget;

  public MyListPage(AppiumDriver<?> driver) {
    super(driver);
  }

  public NavigationWidget navigation() {
    return navigationWidget;
  }

}
