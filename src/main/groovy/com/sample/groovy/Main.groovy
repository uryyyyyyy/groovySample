package com.sample.groovy

class Main {
	static void main(String[] args) {
		SampleUtil.log()
		GroovyUtil.util()
		def vo1 = new GroovyModel1(10, "uryyyyyyy")
		def vo2 = new GroovyModel1(10, "uryyyyyyy")
		def vo3 = new GroovyModel1(vo2)
		//vo.id = 1000
		println vo1
		vo1.getId()
		println vo1.hashCode()
		println vo1.id
		println vo1.name
		println vo1.equals(vo2)
	}
}
