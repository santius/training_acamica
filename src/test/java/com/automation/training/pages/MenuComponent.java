package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuComponent extends BasePage<AndroidDriver<AndroidElement>> {

	@AndroidFindBy(id = "org.wikipedia:id/menu_overflow_button")
	private AndroidElement textMenuOverflow;

	@AndroidFindBy(id = "org.wikipedia:id/menu_feed_search")
	private AndroidElement textMenuFeedSearch;

	protected MenuComponent(AppiumDriver<?> driver) {
		super(driver);
	}

	/**
	 * Opens the menu.
	 * 
	 * @return {@link MenuComponent}
	 */
	public MenuComponent openMenu() {
		click(textMenuOverflow);
		return this;
	}
}
