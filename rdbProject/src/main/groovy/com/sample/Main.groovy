package com.sample

import groovy.sql.GroovyRowResult
import groovy.sql.Sql

println "rdbProject start!"

serverName = "jdbc:jtds:sqlserver://serverName/dbName-CLASS;domain=domainName"
userName = "username"
password = "password"
jdbcDriverName = "org.mariadb.jdbc.Driver"

sql = Sql.newInstance(serverName, userName, password, jdbcDriverName)
sql.eachRow("select * from tableName", { println it.id + " -- ${it.firstName} --"} );

List<GroovyRowResult> rows = sql.rows("select * from tableName")
rows.stream()
		.map{v -> v.Name}
		.forEach{s -> println s}


sql.execute("insert into people (firstName, lastName) values (?,?)", ["yue", "wu"])

comment = "Lazy bum"
sql.executeUpdate("update people set comment = ? where id=002", [comment])

sql.close()