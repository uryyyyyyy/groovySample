package com.sample.utils

class Config {
	private static def config = new ConfigSlurper().parse(new File('conf/config.groovy').toURL())
	static String strSample = config.strSample
	static int intSample = config.intSample
	static boolean boolSample = config.boolSample
}
