package com.automation.training.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class MyListPage extends BasePage {

  NavigationWidget navigationWidget;

  public MyListPage(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public NavigationWidget navigation() {
    return navigationWidget;
  }

}
