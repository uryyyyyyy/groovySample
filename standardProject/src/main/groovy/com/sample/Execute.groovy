package com.sample

import com.sample.utils.Config
import groovy.transform.CompileStatic
import groovy.util.logging.Log

@Log
@CompileStatic
class Execute {

	static void execute(){
		log.info 'info dayo-'
		log.severe 'Severe dayo-'
	}

	static void loadProperties(){
		assert 'ury' == Config.strSample
		assert 10 == Config.intSample
		assert Config.boolSample
	}
}
