package com.automation.training.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;

@AndroidFindBy(id = "org.wikipedia:id/page_list_item_container")
public class ResultItemWidget extends Widget {

	@AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
	private AndroidElement textTitle;

	@AndroidFindBy(id = "org.wikipedia:id/page_list_item_description")
	private AndroidElement textDescription;

	@AndroidFindBy(id = " org.wikipedia:id/page_list_item_redirect")
	private AndroidElement textRedirect;

	protected ResultItemWidget(WebElement element) {
		super(element);
	}

	/**
	 * Get the title of item.
	 * 
	 * @return The tile of item
	 */
	public String getTitle() {
		return textTitle.getText();
	}

	/**
	 * Get the description of item.
	 * 
	 * @return The description of item
	 */
	public String getDescription() {
		return textTitle.getText();
	}

}
