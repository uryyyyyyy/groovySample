package com.sample.dao.util;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig
import groovy.transform.CompileStatic;

@CompileStatic
class H2Util {

	static EbeanServer s = init();

	private static EbeanServer init(){
		ServerConfig config = new ServerConfig();
		config.setName("h2");

		DataSourceConfig h2Config = new DataSourceConfig();
		h2Config.setDriver("org.h2.Driver");
		h2Config.setUsername("sa");
		h2Config.setPassword("");
		h2Config.setUrl("jdbc:h2:mem:tests;DB_CLOSE_DELAY=-1");
		h2Config.setHeartbeatSql("select 1");
		config.setDataSourceConfig(h2Config);
		return EbeanServerFactory.create(config);
	}

	static void check(){
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got " + i + " - DataSource good.");
	}
}
