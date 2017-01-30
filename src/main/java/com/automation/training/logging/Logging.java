package com.automation.training.logging;

import org.pmw.tinylog.Logger;

public interface Logging {
	default void log(String args) {
		Logger.info(args);
	}
}