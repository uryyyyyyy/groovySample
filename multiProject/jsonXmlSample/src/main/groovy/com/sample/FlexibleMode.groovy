package com.sample

import com.sample.util.MyLogger
import groovy.json.JsonSlurper
import org.codehaus.groovy.runtime.typehandling.GroovyCastException

class FlexibleMode {
	static void main() {
		def slurper = new JsonSlurper()
		def text = ClassLoader.getSystemClassLoader().getResource("sample.json").text
		def jObject = slurper.parseText(text)
		MyLogger.log.error jObject[0]
		MyLogger.log.error jObject[1]

		String val = jObject[1].get("key1")
		MyLogger.log.error val

		try{
			Long val2 = jObject[1].get("key1")
		}catch(GroovyCastException e){
			MyLogger.log.error "${jObject[1].get("key1")} is not Long"
		}
	}
}
