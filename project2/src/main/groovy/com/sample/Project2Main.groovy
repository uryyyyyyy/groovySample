package com.sample

import com.sample.dao.http.HttpClient
import com.sample.util.MyLogger

class Project2Main {
	static void main(String[] args) {
		def log = MyLogger.log
		//log.error HttpClient.get("https://www.google.co.jp/")
		log.error HttpClient.post("https://www.google.co.jp/")

	}
}
