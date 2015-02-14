package com.sample.util

import groovy.transform.CompileStatic;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

@CompileStatic
class ConfigProvider {

	static PropertiesConfiguration get(String fileName) {
		try {
			return new PropertiesConfiguration(fileName);
		} catch (ConfigurationException e) {
			MyLogger.log.error("file: ${fileName} is not found")
			throw new RuntimeException(e);
		}
	}

}