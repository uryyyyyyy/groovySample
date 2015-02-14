package com.sample.dao.model1

import com.sample.dao.model1.entity.Model1

interface Model1Dao {
	Model1 getById(int id)

	void checkConnection()
}
