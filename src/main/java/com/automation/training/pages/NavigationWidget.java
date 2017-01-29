package com.automation.training.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NavigationWidget extends BasePage<AndroidDriver<AndroidElement>> {

  @AndroidFindBy(uiAutomator = "text(\"Explore\")")
  private AndroidElement explore;

  @AndroidFindBy(uiAutomator = "text(\"My lists\")")
  private AndroidElement myList;

  @AndroidFindBy(uiAutomator = "text(\"History\")")
  private AndroidElement history;

  @AndroidFindBy(uiAutomator = "text(\"Nearby\")")
  private AndroidElement nearby;

  protected NavigationWidget(AndroidDriver<AndroidElement> driver) {
    super(driver);
  }

  public void clickMyExplore() {
    click(explore);
  }

  public MyListPage goToMyList() {
    click(myList);
    return new MyListPage(getDriver());
  }

  public HistoryPage goToHistory() {
    click(history);
    return new HistoryPage(getDriver());
  }

  public void goTokNearby() {
    click(nearby);
  }
}
