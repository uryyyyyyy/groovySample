package com.sample

import com.sample.dao.model1.Model1DaoRdb
import com.sample.util.ConfigProvider
import com.sample.util.MyLogger
import groovy.transform.CompileStatic

@CompileStatic
class RdbMain {
	static void main(String[] args) {
		def dao = new Model1DaoRdb("h2")
		dao.checkConnection()
		MyLogger.log.error "sss"
		def config = ConfigProvider.get("ebean.properties")
		MyLogger.log.error config.getString("datasource.h2.databaseUrl")
	}
}
