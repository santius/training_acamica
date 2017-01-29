package com.automation.training.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class HistoryPage extends BasePage {

  NavigationWidget navigationWidget;

  public HistoryPage(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public NavigationWidget getNavigationWidget() {
    return navigationWidget;
  }

}
