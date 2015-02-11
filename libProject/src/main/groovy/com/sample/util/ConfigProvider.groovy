package com.sample.util

import groovy.transform.CompileStatic;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

@CompileStatic
class ConfigProvider {

	static PropertiesConfiguration config = init();

	static PropertiesConfiguration init() {
		try {
			return new PropertiesConfiguration("project.properties");
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

}