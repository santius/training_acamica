package com.automation.training.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuWidget extends BasePage<AndroidDriver<AndroidElement>> {

  @AndroidFindBy(id = "org.wikipedia:id/menu_overflow_button")
  private AndroidElement textMenuOverflow;

  @AndroidFindBy(id = "org.wikipedia:id/menu_feed_search")
  private AndroidElement textMenuFeedSearch;

  @FindBy(how = How.NAME, using = "Log in to Wikipedia")
  private AndroidElement textLoginWikipedia;

  protected MenuWidget(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public void clicMenuOverflow() {
    click(textMenuOverflow);
  }

  public LoginPage openLogIn() {
    clicMenuOverflow();
    click(textLoginWikipedia);
    return new LoginPage(getDriver());
  }


}
