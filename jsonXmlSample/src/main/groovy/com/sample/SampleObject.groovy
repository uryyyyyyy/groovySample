package com.sample

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.ToString

@CompileStatic
@Canonical
@ToString
class SampleObject {

	String str
	int int_
	boolean bool
	long datetime

	SampleObject(String str, int int_, boolean bool, long datetime) {
		this.str = str
		this.int_ = int_
		this.bool = bool
		this.datetime = datetime
	}

	SampleObject() {
	}
}
