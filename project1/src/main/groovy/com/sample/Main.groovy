package com.sample

import com.sample.util.ConfigProvider
import com.sample.util.MyLogger
import groovy.transform.CompileStatic
import org.apache.commons.configuration.PropertiesConfiguration

@CompileStatic
class Main {
	static void main(String[] args) {
		PropertiesConfiguration config = ConfigProvider.config;
		def log = MyLogger.log
		log.info config.getString("foo")
		log.warn config.getString("foo")
		log.error config.getString("foo")
	}
}
