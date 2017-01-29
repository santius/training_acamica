package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiHomePage extends BasePage{
	
	 
	public WikiHomePage(WebDriver driver) {
		super(driver);
		driver.get("http://wikipedia.org");
	}

	@FindBy(id="searchInput")
	private WebElement searchInput;
	
	@FindBy(xpath="//*[@id='search-form']/fieldset/button")
	private WebElement searchButton;
	
	public ArticlePage buscar(String busqueda) {
		searchInput.sendKeys(busqueda);
		searchButton.click();
		return new ArticlePage(getDriver());
	}
}
