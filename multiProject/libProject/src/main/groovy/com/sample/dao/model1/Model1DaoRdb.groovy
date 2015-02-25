package com.sample.dao.model1

import com.avaje.ebean.Ebean
import com.avaje.ebean.EbeanServer
import com.avaje.ebean.SqlRow
import com.sample.dao.model1.entity.Model1

class Model1DaoRdb implements Model1Dao{

	final String SERVER_NAME;

	Model1DaoRdb(String serverName) {
		this.SERVER_NAME = serverName
	}

	@Override
	Model1 getById(int id) {
		EbeanServer s = Ebean.getServer(SERVER_NAME);
		s.find(Model1.class, id)
	}

	@Override
	void checkConnection() {
		EbeanServer s = Ebean.getServer(SERVER_NAME);
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got "+i+" - DataSource good.");
	}
}
