package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WikiHomePage extends BasePage<AndroidDriver<AndroidElement>> {

	NavigationComponent navigationComponent;
	MenuComponent menuComponent;

	@AndroidFindBy(id = "org.wikipedia:id/search_container")
	private AndroidElement layoutSearch;

	public WikiHomePage(AppiumDriver<?> driver) {
		super(driver);
		navigationComponent = new NavigationComponent(getDriver());
		menuComponent = new MenuComponent(getDriver());
	}

	/**
	 * Gets the {@link NavigationComponent}.
	 * 
	 * @return A instance of {@link NavigationComponent}.
	 */
	public NavigationComponent navigation() {
		return navigationComponent;
	}

	/**
	 * Gets the {@link MenuComponent}.
	 * 
	 * @return A instance of {@link MenuComponent}.
	 */
	public MenuComponent menu() {
		return menuComponent;
	}

	/**
	 * Opens the {@link SearchPage}.
	 * 
	 * @return A new instance of {@link SearchPage}.
	 */
	public SearchPage openSearch() {
		click(layoutSearch);
		return new SearchPage(getDriver());
	}

}
