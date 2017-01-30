package com.automation.training.appium;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Integer.compare;
import static java.lang.String.format;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.net.InetAddresses;

public class AppiumServerAddress {

	private String ip;
	private int port;
	private URL remoteAddress;

	/**
	 * Create a new instance of {@link AppiumServerAddress} a remote Appium server
	 * address.
	 * 
	 * @param pIP
	 *            The server IP.
	 * @param pPort
	 *            The server port. Should be >= 1024 and <= 65535.
	 */
	public AppiumServerAddress(final String pIP, final int pPort) {
		checkNotNull(pIP);
		checkArgument(InetAddresses.isInetAddress(pIP), "The supplied argument [%s] is not an IPv4 valid address.",
				pIP);

		checkNotNull(pPort);
		checkArgument(compare(pPort, 1024) > compare(pPort, 65535), "The supplied argument [%s] is not a valid port.",
				pPort);

		ip = pIP;
		port = pPort;
		setRemoteAddress();
	}

	/**
	 * Sets the Appium server remote address.
	 * 
	 * @throws RuntimeException
	 *             if no protocol is specified, or an unknown protocol is found,
	 *             or spec is null.
	 */
	private void setRemoteAddress() {
		String address = format("http://%s:%s/wd/hub", ip, port);
		try {
			remoteAddress = new URL(address);
		} catch (MalformedURLException e) {
			throw new RuntimeException(this.getClass().getName() + " The Remote Address is invalid " + address);
		}
	}

	/**
	 * Retrieves the Appium server remote address.
	 * 
	 * @return The Appium server remote address URL.
	 */
	public URL getRemoteAddress() {
		return remoteAddress;
	}
}
