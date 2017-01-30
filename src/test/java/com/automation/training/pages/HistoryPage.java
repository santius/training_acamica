package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HistoryPage extends BasePage<AndroidDriver<AndroidElement>> {

	NavigationComponent navigationComponent;

	public HistoryPage(AppiumDriver<?> driver) {
		super(driver);
	}

	public NavigationComponent getNavigationWidget() {
		return navigationComponent;
	}

}
