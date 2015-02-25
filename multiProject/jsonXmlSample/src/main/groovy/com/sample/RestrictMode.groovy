package com.sample

import com.fasterxml.jackson.databind.ObjectMapper
import com.sample.util.MyLogger
import groovy.transform.CompileStatic

import java.time.ZoneId
import java.time.ZonedDateTime

@CompileStatic
class RestrictMode {
	static void main() {
		ZonedDateTime date = new Date().toInstant().atZone(ZoneId.systemDefault())
		def obj1 = new SampleObject("str", 100, true, date.toEpochSecond())
		ObjectMapper mapper = new ObjectMapper()

		def json = mapper.writeValueAsString(obj1)
		MyLogger.log.error json

		SampleObject obj2 = mapper.readValue(json, SampleObject.class)
		MyLogger.log.error obj2.toString()
	}
}
