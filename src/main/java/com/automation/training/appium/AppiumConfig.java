package com.automation.training.appium;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import com.automation.training.appium.MobileDriverFactory.MobileDriver;

@Sources("file:src/test/resources/appium.config")
public interface AppiumConfig extends Config {

	@Key("device.name")
	@DefaultValue("${device.name}")
	String deviceName();

	@Key("platform")
	@DefaultValue("ANDROID")
	MobileDriver platform();
	
	@Key("platform.version")
	@DefaultValue("")
	String platformVersion();
	
	@Key("app")
	@DefaultValue("${app}")
	String app();

	@Key("android.app.package")
	String appPackage();

	@Key("android.app.activity")
	String appActivity();

	@Key("appium.server.ip")
	@DefaultValue("127.0.0.1")
	String appiumServerIp();

	@Key("appium.server.port")
	@DefaultValue("4723")
	int appiumServerPort();
	
	@Key("appium.new.command.timeout")
	@DefaultValue("120")
	int newCommandTimeout();
	
	@Key("appium.timeout")
	@DefaultValue("60")
	int timeout();	
}
