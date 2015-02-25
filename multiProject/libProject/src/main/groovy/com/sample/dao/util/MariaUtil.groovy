package com.sample.dao.util;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlRow
import com.avaje.ebean.config.DataSourceConfig
import com.avaje.ebean.config.ServerConfig
import groovy.transform.CompileStatic;

@CompileStatic
class MariaUtil {

	static EbeanServer s = init();

	private static EbeanServer init(){
		ServerConfig config = new ServerConfig();
		config.setName("h2");

		DataSourceConfig h2Config = new DataSourceConfig();
		h2Config.setDriver("org.postgresql.Driver");
		h2Config.setUsername("test");
		h2Config.setPassword("test");
		h2Config.setUrl("jdbc:postgresql://127.0.0.1:5432/test");
		h2Config.setHeartbeatSql("select count(*) from t_one");
		config.setDataSourceConfig(h2Config);
		return Ebean.getServer("h2");
	}

	static void check(){
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got " + i + " - DataSource good.");
	}
}
