package com.sample.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Jdk14Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class MyLogger {

	public static Log log = init();

	private static Log init() {
		try {
			System.out.println("load logging");
			InputStream configFile = new FileInputStream("logging.properties");
			LogManager.getLogManager().readConfiguration(configFile);
			return new Jdk14Logger("log");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

}