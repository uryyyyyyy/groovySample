package com.sample.dao.model1

import groovy.transform.Canonical
import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@CompileStatic
@Canonical
@Entity
@Table(name="e_junktable")
public class Model1 {

	@Id
	Integer id;

	String name;

	Model1() {
	}
	Model1(Integer id, String name) {
		this.id = id
		this.name = name
	}
}