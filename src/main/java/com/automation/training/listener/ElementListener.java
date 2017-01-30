package com.automation.training.listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.training.logging.Logging;

import io.appium.java_client.events.api.general.ElementEventListener;
import static java.lang.String.format;

public class ElementListener implements ElementEventListener, Logging {

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		String text = element.getText();
		String type = element.getTagName();
		log(format("Click on element: type: [%s] text: [%s]", type, text));
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

}
