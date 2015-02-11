package com.sample

import com.avaje.ebean.Ebean
import com.avaje.ebean.EbeanServer
import com.avaje.ebean.SqlRow
import groovy.transform.CompileStatic

@CompileStatic
class RdbMain {
	static void main(String[] args) {
//		def s = H2Util.s
//		def e = new Model1(10, "name")
//		s.save(e)
		EbeanServer s = Ebean.getServer("mysql");
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got "+i+" - DataSource good.");
	}
}
