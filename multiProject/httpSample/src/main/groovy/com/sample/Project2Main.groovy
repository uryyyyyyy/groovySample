package com.sample

import com.sample.dao.http.HttpClient
import com.sample.util.MyLogger
import groovy.transform.CompileStatic

@CompileStatic
class Project2Main {
	static void main(String[] args) {
		def log = MyLogger.log
		log.info HttpClient.get("https://www.google.co.jp/")
		log.info HttpClient.post("https://www.google.co.jp/", null)
	}
}
