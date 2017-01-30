package com.automation.training.appium;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.BROWSER_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.training.listener.ElementListener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MobileDriverFactory {

	public AppiumDriver<?> getDriver(AppiumConfig config) {
		DesiredCapabilities cap = new DesiredCapabilities();
		AppiumServerAddress address = new AppiumServerAddress(config.appiumServerIp(), config.appiumServerPort());
		cap.setCapability(BROWSER_NAME, config.deviceName());
		cap.setCapability(DEVICE_NAME, config.deviceName());
		cap.setCapability(PLATFORM, config.platform().toString());
		cap.setCapability(PLATFORM_VERSION, config.platformVersion());
		cap.setCapability(NEW_COMMAND_TIMEOUT, config.newCommandTimeout());
		cap.setCapability(APP, config.app());

		AppiumDriver<?> driver = config.platform().setDriver(address, cap, config);
		driver.manage().timeouts().implicitlyWait(1, SECONDS);
		driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ElementListener());
		return driver;
	}

	public enum MobileDriver {

		ANDROID {
			@Override
			public AndroidDriver<AndroidElement> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
					AppiumConfig config) {
				cap.setCapability("appPackage", config.appPackage());
				cap.setCapability("appActivity", config.appActivity());
				return new AndroidDriver<AndroidElement>(address.getRemoteAddress(), cap);
			}
		},
		
		IOS {
			@Override
			public IOSDriver<IOSElement> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
					AppiumConfig config) {
				return new IOSDriver<IOSElement>(address.getRemoteAddress(), cap);
			}
		};

		public abstract AppiumDriver<?> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
				AppiumConfig config);
	}

}
