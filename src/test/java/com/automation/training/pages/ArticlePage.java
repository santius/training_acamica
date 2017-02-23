package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ArticlePage extends BasePage<AndroidDriver<AndroidElement>> {

	@AndroidFindBy(id = ID_PREFIX + "view_article_title_text")
	private AndroidElement textArticleTitle;

	@AndroidFindBy(uiAutomator = "description(\"Navigate up\")")
	private AndroidElement imageClose;

	public ArticlePage(AppiumDriver<?> driver) {
		super(driver);
	}

	public String getArticleTitle() {
		return getText(textArticleTitle);
	}

	public ArticlePage close() {
		click(imageClose);
		return this;
	}

}
