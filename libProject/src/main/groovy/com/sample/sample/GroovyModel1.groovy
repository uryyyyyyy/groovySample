package com.sample.sample

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class GroovyModel1 {

	final int id
	final String name

	GroovyModel1(int id, String name) {
		this.id = id
		this.name = name
	}

	GroovyModel1(GroovyModel1 vo){
		this.id = vo.id
		this.name = vo.name
	}
}
