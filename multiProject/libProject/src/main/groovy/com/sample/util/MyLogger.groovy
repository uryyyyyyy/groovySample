package com.sample.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Jdk14Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

class MyLogger {

	private static String getProperties() {
		return "handlers=java.util.logging.ConsoleHandler, java.util.logging.FileHandler\n"+
				"java.util.logging.ConsoleHandler.level=SEVERE\n"+
				"java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter"+
				"java.util.logging.FileHandler.level=INFO\n"+
				"java.util.logging.FileHandler.pattern=logs/${new Date().toString()}.log\n"+
				"java.util.logging.FileHandler.formatter=java.util.logging.SimpleFormatter"
		;
	}

	static Log log = init();

	private static Log init() {
		try {
			System.out.println("load logging");
			InputStream inStream = new ByteArrayInputStream(getProperties().getBytes("UTF-8"));
			LogManager.getLogManager().readConfiguration(inStream);
			return new Jdk14Logger("log");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

}