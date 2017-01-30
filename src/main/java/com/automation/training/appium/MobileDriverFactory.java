package com.automation.training.appium;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.BROWSER_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MobileDriverFactory {

	public AppiumDriver<?> getDriver(AppiumConfig config) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		AppiumServerAddress address = new AppiumServerAddress(config.appiumServerIp(), config.appiumServerPort());
		capabilities.setCapability(BROWSER_NAME, config.deviceName());
		capabilities.setCapability(DEVICE_NAME, config.deviceName());
		capabilities.setCapability(PLATFORM, config.platform().toString());
		capabilities.setCapability(PLATFORM_VERSION, config.platformVersion());
		capabilities.setCapability(NEW_COMMAND_TIMEOUT, config.newCommandTimeout());
		capabilities.setCapability(APP, config.app());

		AppiumDriver<?> driver = config.platform().setDriver(address, capabilities, config);
		driver.manage().timeouts().implicitlyWait(1, SECONDS);
		return driver;
	}

	public enum MobileDriver {

		ANDROID {
			@Override
			public AndroidDriver<AndroidElement> setDriver(AppiumServerAddress address, DesiredCapabilities capabilities,
					AppiumConfig config) {
				capabilities.setCapability("appPackage", config.appPackage());
				capabilities.setCapability("appActivity", config.appActivity());
				return new AndroidDriver<AndroidElement>(address.getRemoteAddress(), capabilities);
			}
		},
		IOS {
			@Override
			public IOSDriver<IOSElement> setDriver(AppiumServerAddress address, DesiredCapabilities capabilities,
					AppiumConfig config) {
				return new IOSDriver<IOSElement>(address.getRemoteAddress(), capabilities);
			}
		};

		public abstract AppiumDriver<?> setDriver(AppiumServerAddress address, DesiredCapabilities capabilities,
				AppiumConfig config);
	}

}
