package com.sample

import com.avaje.ebean.Ebean
import com.avaje.ebean.EbeanServer
import com.avaje.ebean.SqlRow
import org.junit.Test


class RdbMainTest {

	@Test
	public void test() {
		EbeanServer s = Ebean.getServer("h2");
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got "+i+" - DataSource good.");
	}
}
