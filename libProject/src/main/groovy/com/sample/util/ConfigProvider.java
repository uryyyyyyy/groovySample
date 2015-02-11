package com.sample.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigProvider {

	public static PropertiesConfiguration config = init();

	private static PropertiesConfiguration init() {
		try {
			return new PropertiesConfiguration("project.properties");
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

}