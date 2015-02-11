package com.sample

import com.sample.util.ConfigProvider
import org.apache.commons.configuration.PropertiesConfiguration

class Main {
	static void main(String[] args) {
		PropertiesConfiguration config = ConfigProvider.config;
		println(config.getString("foo"));
		println(config.getString("foo"));
		println(config.getString("foo"));
		println(config.getString("foo"));
	}
}
