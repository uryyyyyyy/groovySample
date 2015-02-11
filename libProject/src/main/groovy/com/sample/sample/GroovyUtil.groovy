package com.sample.sample

import groovy.transform.CompileStatic

@CompileStatic
class GroovyUtil {
	static String util() {
		return "Groovy Version = ${GroovySystem.version}"
	}
}
