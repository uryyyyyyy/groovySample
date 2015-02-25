package com.sample.utils

import groovy.transform.CompileStatic
import groovy.util.logging.Log

import java.util.logging.ConsoleHandler
import java.util.logging.FileHandler

@Log
@CompileStatic
class MyLogger {
	static void setUpLogger(){
		def fileHandler = new FileHandler("logs/${new Date().toString()}.log")
		def consoleHandler = new ConsoleHandler()
		log.addHandler(fileHandler)
		log.addHandler(consoleHandler)
	}
}
