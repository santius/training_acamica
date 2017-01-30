package com.automation.training.pages;


import com.automation.training.appium.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BasePage<AndroidDriver<AndroidElement>> {

  @AndroidFindBy(id = "org.wikipedia:id/login_username_text")
  private AndroidElement inputUsername;

  @AndroidFindBy(uiAutomator = "text(\"Enter password.. Double tap to edit.\")")
  private AndroidElement inputPassword;

  @AndroidFindBy(id = "org.wikipedia:id/text_input_password_toggle")
  private AndroidElement imageToggle;

  @AndroidFindBy(id = "org.wikipedia:id/login_button")
  private AndroidElement buttonLogin;

  public LoginPage(AppiumDriver<?> driver) {
    super(driver);
  }

  public LoginPage writeUsername(final String username) {
    type(inputUsername, username);
    return this;
  }

  public LoginPage writePassword(final String password) {
    type(inputPassword, password);
    return this;
  }
  
  public void login(final String username, final String password){
    writeUsername(username);
    writePassword(password);
    click(buttonLogin);
  }  

}
